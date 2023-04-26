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

import proyecto.grupo07.idat.model.ProductoPerso;


public class PersonalizadoExporterPDF {
	private List<ProductoPerso> listapedidospersonalizados;

	public PersonalizadoExporterPDF(List<ProductoPerso> listapedidos) {
		super();
		this.listapedidospersonalizados = listapedidos;
	}

	private void escribirCabeceraDeLaTabla(PdfPTable tabla) {
		PdfPCell celda = new PdfPCell();

		celda.setBackgroundColor(Color.BLUE);
		celda.setPadding(5);

		Font fuente = FontFactory.getFont(FontFactory.HELVETICA);
		fuente.setColor(Color.WHITE);

		celda.setPhrase(new Phrase("IdProductoPersonalizado", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Nombre", fuente));
		tabla.addCell(celda);
		
		celda.setPhrase(new Phrase("Imagen", fuente));
		tabla.addCell(celda);
		
		celda.setPhrase(new Phrase("Cantidad", fuente));
		tabla.addCell(celda);
		
		
		celda.setPhrase(new Phrase("Precio", fuente));
		tabla.addCell(celda);
		
		celda.setPhrase(new Phrase("Porciones", fuente));
		tabla.addCell(celda);
		
		
		celda.setPhrase(new Phrase("Cake", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Relleno", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Accesorios", fuente));
		tabla.addCell(celda);
		
		celda.setPhrase(new Phrase("Dedicatoria", fuente));
		tabla.addCell(celda);
		
	
	
	}

	private void escribirDatosDeLaTabla(PdfPTable tabla) {
		for (ProductoPerso pedido : listapedidospersonalizados) {
			tabla.addCell(String.valueOf(pedido.getId_producto_perso()));
			tabla.addCell(String.valueOf(pedido.getNombre()));
			tabla.addCell(String.valueOf(pedido.getImagen()));
			tabla.addCell(String.valueOf(pedido.getCantidad()));
			tabla.addCell(String.valueOf(pedido.getPrecio()));
			tabla.addCell(String.valueOf(pedido.getPorciones()));
			tabla.addCell(String.valueOf(pedido.getCake()));
			tabla.addCell(String.valueOf(pedido.getRelleno()));
			tabla.addCell(String.valueOf(pedido.getAccesorios()));
			tabla.addCell(String.valueOf(pedido.getDedicatoria()));
			
		}
	}

	public void exportar(HttpServletResponse response) throws DocumentException, IOException {
		Document documento = new Document(PageSize.A4);
		PdfWriter.getInstance(documento, response.getOutputStream());

		documento.open();

		Font fuente = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		fuente.setColor(Color.RED);
		fuente.setSize(18);

		Paragraph titulo = new Paragraph("Listado de Pedidos Personalizados", fuente);
		titulo.setAlignment(Paragraph.ALIGN_CENTER);
		documento.add(titulo);

		PdfPTable tabla = new PdfPTable(10);
		tabla.setWidthPercentage(100);
		tabla.setSpacingBefore(15);
		tabla.setWidths(new float[] { 2f, 4f,3f, 2f, 2f,2f,3f,4f,4f,4f});
		tabla.setWidthPercentage(110);

		escribirCabeceraDeLaTabla(tabla);
		escribirDatosDeLaTabla(tabla);

		documento.add(tabla);
		documento.close();
	}
	
	
}
