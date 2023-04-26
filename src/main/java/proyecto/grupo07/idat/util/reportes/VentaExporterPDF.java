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

import proyecto.grupo07.idat.model.DetallePedido;



public class VentaExporterPDF {
	private List<DetallePedido> listapedidos;

	public VentaExporterPDF(List<DetallePedido> listapedidos) {
		super();
		this.listapedidos = listapedidos;
	}

	private void escribirCabeceraDeLaTabla(PdfPTable tabla) {
		PdfPCell celda = new PdfPCell();

		celda.setBackgroundColor(Color.BLUE);
		celda.setPadding(5);

		Font fuente = FontFactory.getFont(FontFactory.HELVETICA);
		fuente.setColor(Color.WHITE);

		celda.setPhrase(new Phrase("idPedido", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("NombreProducto", fuente));
		tabla.addCell(celda);
		
		celda.setPhrase(new Phrase("Imagen Pedido", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Fecha Pedido", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Precio", fuente));
		tabla.addCell(celda);
		
		celda.setPhrase(new Phrase("Cantidad", fuente));
		tabla.addCell(celda);
		
		celda.setPhrase(new Phrase("Total", fuente));
		tabla.addCell(celda);
		
		celda.setPhrase(new Phrase("Estado", fuente));
		tabla.addCell(celda);
		
	
	}

	private void escribirDatosDeLaTabla(PdfPTable tabla) {
		for (DetallePedido compra : listapedidos) {
			tabla.addCell(String.valueOf(compra.getId_detalle_pedido()));
			tabla.addCell(String.valueOf(compra.getNombre()));
			tabla.addCell(String.valueOf(compra.getImagen()));
			tabla.addCell(compra.getFecha_emision().toString());
			tabla.addCell(String.valueOf(compra.getPrecio()));
			tabla.addCell(String.valueOf(compra.getCantidad()));
			tabla.addCell(String.valueOf(compra.getTotal()));
			tabla.addCell(String.valueOf(compra.getEstado()));
			
		}
	}

	public void exportar(HttpServletResponse response) throws DocumentException, IOException {
		Document documento = new Document(PageSize.A4);
		PdfWriter.getInstance(documento, response.getOutputStream());

		documento.open();

		Font fuente = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		fuente.setColor(Color.BLUE);
		fuente.setSize(18);

		Paragraph titulo = new Paragraph("Listado de los Pedidos de Venta", fuente);
		titulo.setAlignment(Paragraph.ALIGN_CENTER);
		documento.add(titulo);

		PdfPTable tabla = new PdfPTable(8);
		tabla.setWidthPercentage(100);
		tabla.setSpacingBefore(15);
		tabla.setWidths(new float[] { 2.3f, 4f,3.5f, 3f, 2f,2f,3f,3f});
		tabla.setWidthPercentage(110);

		escribirCabeceraDeLaTabla(tabla);
		escribirDatosDeLaTabla(tabla);

		documento.add(tabla);
		documento.close();
	}
	
	
	
	
	
}
