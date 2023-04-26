package proyecto.grupo07.idat.util.reportes;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import proyecto.grupo07.idat.model.DetallePedido;


public class VentaExporterExcel {

	private XSSFWorkbook libro;
	private XSSFSheet hoja;

	private List<DetallePedido> listapedidos;

	public VentaExporterExcel(List<DetallePedido> listapedidos) {
		this.listapedidos = listapedidos;
		libro = new XSSFWorkbook();
		hoja = libro.createSheet("Pedidos Realizados por los Clientes");
	}

	private void escribirCabeceraDeTabla() {
		Row fila = hoja.createRow(0);
		
		CellStyle estilo = libro.createCellStyle();
		XSSFFont fuente = libro.createFont();
		fuente.setBold(true);
		fuente.setFontHeight(16);
		estilo.setFont(fuente);
		
		Cell celda = fila.createCell(0);
		celda.setCellValue("ID_PEDIDO");
		celda.setCellStyle(estilo);
		
		
		celda = fila.createCell(1);
		celda.setCellValue("NOMBRE DE PRODUCTO");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(2);
		celda.setCellValue("IMAGEN");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(3);
		celda.setCellValue("FECHA");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(4);
		celda.setCellValue("PRECIO");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(5);
		celda.setCellValue("CANTIDAD");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(6);
		celda.setCellValue("TOTAL");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(7);
		celda.setCellValue("ESTADO");
		celda.setCellStyle(estilo);
	
	}
	
	private void escribirDatosDeLaTabla() {
		int nueroFilas = 1;
		
		CellStyle estilo = libro.createCellStyle();
		XSSFFont fuente = libro.createFont();
		fuente.setFontHeight(14);
		estilo.setFont(fuente);
		
		for(DetallePedido compra : listapedidos) {
			Row fila = hoja.createRow(nueroFilas ++);
			
			Cell celda = fila.createCell(0);
			celda.setCellValue(compra.getId_detalle_pedido());
			hoja.autoSizeColumn(0);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(1);
			celda.setCellValue(compra.getNombre());
			hoja.autoSizeColumn(1);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(2);
			celda.setCellValue(compra.getImagen());
			hoja.autoSizeColumn(2);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(3);
			celda.setCellValue(compra.getFecha_emision());
			hoja.autoSizeColumn(3);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(4);
			celda.setCellValue(compra.getPrecio());
			hoja.autoSizeColumn(4);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(5);
			celda.setCellValue(compra.getCantidad());
			hoja.autoSizeColumn(5);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(6);
			celda.setCellValue(compra.getTotal());
			hoja.autoSizeColumn(6);
			celda.setCellStyle(estilo);
			
			
			celda = fila.createCell(7);
			celda.setCellValue(compra.getEstado());
			hoja.autoSizeColumn(7);
			celda.setCellStyle(estilo);
			
		}
	}
	
	public void exportar(HttpServletResponse response) throws IOException {
		escribirCabeceraDeTabla();
		escribirDatosDeLaTabla();
		
		ServletOutputStream outPutStream = response.getOutputStream();
		libro.write(outPutStream);
		
		libro.close();
		outPutStream.close();
	}
}
