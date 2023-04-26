package proyecto.grupo07.idat.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
/*EN PROYECTO*/
@Controller
public class MainController {
	private Long ver=new Date().getTime();	
	
	@PersistenceContext
	private EntityManager em;
	
    @RequestMapping(value="/")
    @ResponseBody
    ModelAndView home() {
    	ModelAndView mav=new ModelAndView();
    	
    	mav.setViewName("indexd");
    	mav.addObject( "ver", ver);
    	mav.addObject( "Imagen", getPedidos() );
    	
        return mav;
    	}	
    
    @RequestMapping(value="/api")
    @ResponseBody
    HashMap<String,Object> api(
    		@RequestParam(value="from") String from1,
    		@RequestParam(value="to") String to1,
    		@RequestParam(value="video") String video1
    		) {
    	HashMap<String,Object> r=new HashMap<String,Object>();
    	
    	r.put( "subsdia" , getSubscriptoresDia( from1, to1, video1) );
       	r.put( "subssem" , getSubscriptoresSemana( from1, to1, video1) );
       	r.put( "subsmes" , getSubscriptoresMes( from1, to1, video1) );
        
    	return r;
    	}
    
    private List<Object[]> getSubscriptoresSemana(String from1, String to1, String video1) {
    	String sql="SELECT DAYNAME(fecha),sum(cantidad) FROM detalle_pedido";
    	String where=getConditionalSql(from1, to1, video1);
    	
    	sql+=where+" group by WEEKDAY(fecha)";
               
        return getSqlValues(sql,from1, to1, video1);
    	}
    
    
    private List<Object[]> getSubscriptoresMes(String from1, String to1, String video1) {
    	String sql="SELECT MONTHNAME(fecha),sum(cantidad) FROM detalle_pedido";
    	String where=getConditionalSql(from1, to1, video1);
    	
    	sql+=where+" group by MONTH(fecha)";
               
        return getSqlValues(sql,from1, to1, video1);
    	}
    
    
    
    private List<Object[]> getSubscriptoresDia(String from1, String to1, String video1) {
    	String sql="SELECT fecha,sum(cantidad) FROM detalle_pedido";
    	String where=getConditionalSql(from1, to1, video1);
    	
    	sql+=where+" group by fecha order by fecha desc";
               
        return getSqlValues(sql,from1, to1, video1);
    	} 
    
    private List<Object[]> getSqlValues(String sql,String from1, String to1, String video1) {
    	Query query = em.createNativeQuery(sql);
       	
    	if ( !from1.equals("") ) query.setParameter("from", from1);
    	if ( !to1.equals("") ) query.setParameter("to", to1);
    	if ( !video1.equals("") ) query.setParameter("video", video1);
               
        return query.getResultList();    	
    	}

    private String getConditionalSql(String from1, String to1, String video1) {
    	String where="";
    	if ( !from1.equals("") ) where+=" fecha >= :from ";

    	if ( !to1.equals("") ) {
    		if ( !where.equals("") ) where+=" and ";
    		where+=" fecha <= :to ";
    		}

    	if ( !video1.equals("") ) {
    		if ( !where.equals("") ) where+=" and ";
    		where+=" Imagen = :video ";
    		}
    	
    	if ( !where.equals("") ) where=" where "+where;
    	
    	return where;
    	}    
    
    private List<Object[]> getPedidos() {
    	Query query = em.createNativeQuery("select distinct Imagen, Imagen from detalle_pedido;");
    	return query.getResultList();
    	}    
	
	}
