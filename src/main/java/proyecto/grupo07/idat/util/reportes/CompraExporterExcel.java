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

import proyecto.grupo07.idat.model.DetalleProveedor;

public class CompraExporterExcel {
	private XSSFWorkbook libro;
	private XSSFSheet hoja;

	private List<DetalleProveedor> listaCompras;

	public CompraExporterExcel(List<DetalleProveedor> listaCompras) {
		this.listaCompras = listaCompras;
		libro = new XSSFWorkbook();
		hoja = libro.createSheet("Pedidos de Compras");
	}

	private void escribirCabeceraDeTabla() {
		Row fila = hoja.createRow(0);
		
		CellStyle estilo = libro.createCellStyle();
		XSSFFont fuente = libro.createFont();
		fuente.setBold(true);
		fuente.setFontHeight(16);
		estilo.setFont(fuente);
		
		Cell celda = fila.createCell(0);
		celda.setCellValue("ID_PROVEEDOR");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(1);
		celda.setCellValue("ID_ALMACEN");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(2);
		celda.setCellValue("NOMBRE_INSUMOS");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(3);
		celda.setCellValue("CANTIDAD");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(4);
		celda.setCellValue("DESCRIPCION");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(5);
		celda.setCellValue("PRECIO");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(6);
		celda.setCellValue("FECHA_COMPRA");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(7);
		celda.setCellValue("FECHA_ENTREGA");
		celda.setCellStyle(estilo);
	}
	
	private void escribirDatosDeLaTabla() {
		int nueroFilas = 1;
		
		CellStyle estilo = libro.createCellStyle();
		XSSFFont fuente = libro.createFont();
		fuente.setFontHeight(14);
		estilo.setFont(fuente);
		
		for(DetalleProveedor compra : listaCompras) {
			Row fila = hoja.createRow(nueroFilas ++);
			
			Cell celda = fila.createCell(0);
			celda.setCellValue(compra.getId_proveedor());
			hoja.autoSizeColumn(0);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(1);
			celda.setCellValue(compra.getId_almacen());
			hoja.autoSizeColumn(1);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(2);
			celda.setCellValue(compra.getNombre_insumos());
			hoja.autoSizeColumn(2);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(3);
			celda.setCellValue(compra.getCantidad());
			hoja.autoSizeColumn(3);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(4);
			celda.setCellValue(compra.getDescripcion());
			hoja.autoSizeColumn(4);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(5);
			celda.setCellValue(compra.getPrecio_insumos());
			hoja.autoSizeColumn(5);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(6);
			celda.setCellValue(compra.getFecha_compra_insumos());
			hoja.autoSizeColumn(6);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(7);
			celda.setCellValue(compra.getFecha_entrega_insumos());
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
