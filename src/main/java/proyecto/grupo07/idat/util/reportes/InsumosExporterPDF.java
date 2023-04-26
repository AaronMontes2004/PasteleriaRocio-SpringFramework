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

import proyecto.grupo07.idat.model.Almacen;

public class InsumosExporterPDF {

	private List<Almacen> listainsumos;

	public InsumosExporterPDF(List<Almacen> listainsumos) {
		super();
		this.listainsumos = listainsumos;
	}

	private void escribirCabeceraDeLaTabla(PdfPTable tabla) {
		PdfPCell celda = new PdfPCell();

		celda.setBackgroundColor(Color.GREEN);
		celda.setPadding(5);

		Font fuente = FontFactory.getFont(FontFactory.HELVETICA);
		fuente.setColor(Color.WHITE);

		celda.setPhrase(new Phrase("idAlmacen", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("NombreInsumo", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("CantidadInsumo", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("IdProducto", fuente));
		tabla.addCell(celda);
	}

	private void escribirDatosDeLaTabla(PdfPTable tabla) {
		for (Almacen insumo : listainsumos) {
			tabla.addCell(String.valueOf(insumo.getId_almacen()));
			tabla.addCell(insumo.getInsumos());
			tabla.addCell(String.valueOf(insumo.getCantidad()));
			tabla.addCell(String.valueOf(insumo.getId_producto()));
			
		}
	}

	public void exportar(HttpServletResponse response) throws DocumentException, IOException {
		Document documento = new Document(PageSize.A4);
		PdfWriter.getInstance(documento, response.getOutputStream());

		documento.open();

		Font fuente = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		fuente.setColor(Color.BLACK);
		fuente.setSize(18);

		Paragraph titulo = new Paragraph("Lista de Nuestros Insumos en Almacen", fuente);
		titulo.setAlignment(Paragraph.ALIGN_CENTER);
		documento.add(titulo);

		PdfPTable tabla = new PdfPTable(4);
		tabla.setWidthPercentage(100);
		tabla.setSpacingBefore(15);
		tabla.setWidths(new float[] { 2.3f, 2.3f, 2.3f, 2.3f });
		tabla.setWidthPercentage(110);

		escribirCabeceraDeLaTabla(tabla);
		escribirDatosDeLaTabla(tabla);

		documento.add(tabla);
		documento.close();
	}
}
