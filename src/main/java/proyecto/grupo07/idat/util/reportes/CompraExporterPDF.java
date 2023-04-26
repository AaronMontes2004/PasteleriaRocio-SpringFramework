package proyecto.grupo07.idat.util.reportes;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import proyecto.grupo07.idat.model.DetalleProveedor;


public class CompraExporterPDF {

	private List<DetalleProveedor> listaComprar;

	public CompraExporterPDF(List<DetalleProveedor> listaComprar) {
		super();
		this.listaComprar = listaComprar;
	}

	private void escribirCabeceraDeLaTabla(PdfPTable tabla) {
		PdfPCell celda = new PdfPCell();

		celda.setBackgroundColor(Color.BLUE);
		celda.setPadding(5);

		Font fuente = FontFactory.getFont(FontFactory.HELVETICA);
		fuente.setColor(Color.WHITE);

		celda.setPhrase(new Phrase("idProveedor", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("idAlmacen", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Nombre_Insumos", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Cantidad", fuente));
		tabla.addCell(celda);
		
		celda.setPhrase(new Phrase("Descripcion", fuente));
		tabla.addCell(celda);
		
		celda.setPhrase(new Phrase("Precio", fuente));
		tabla.addCell(celda);
		
		celda.setPhrase(new Phrase("Fecha Compra", fuente));
		tabla.addCell(celda);
		
		celda.setPhrase(new Phrase("Fecha Entrega", fuente));
		tabla.addCell(celda);
	}

	private void escribirDatosDeLaTabla(PdfPTable tabla) {
		for (DetalleProveedor compra : listaComprar) {
			tabla.addCell(String.valueOf(compra.getId_proveedor()));
			tabla.addCell(String.valueOf(compra.getId_almacen()));
			tabla.addCell(compra.getNombre_insumos());
			tabla.addCell(String.valueOf(compra.getCantidad()));
			tabla.addCell(compra.getDescripcion());
			tabla.addCell(String.valueOf(compra.getPrecio_insumos()));
			tabla.addCell(compra.getFecha_compra_insumos().toString());
			tabla.addCell(compra.getFecha_entrega_insumos().toString());
			
		}
	}

	public void exportar(HttpServletResponse response) throws DocumentException, IOException {
		Document documento = new Document(PageSize.A4);
		PdfWriter.getInstance(documento, response.getOutputStream());

		documento.open();

		Font fuente = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		fuente.setColor(Color.BLUE);
		fuente.setSize(18);

		Paragraph titulo = new Paragraph("Listado de los Pedidos de Compra", fuente);
		titulo.setAlignment(Paragraph.ALIGN_CENTER);
		documento.add(titulo);

		PdfPTable tabla = new PdfPTable(8);
		tabla.setWidthPercentage(100);
		tabla.setSpacingBefore(15);
		tabla.setWidths(new float[] { 2.3f, 2.3f, 3f, 2f,6f,2f,4f,4f });
		tabla.setWidthPercentage(110);

		escribirCabeceraDeLaTabla(tabla);
		escribirDatosDeLaTabla(tabla);

		documento.add(tabla);
		documento.close();
	}
	
	
}
