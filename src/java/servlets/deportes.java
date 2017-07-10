package servlets;

import clienteRest.DeporteRest;
import clienteRest.RestEstudiante;
import entities.Deporte;
import entities.Estudiante;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class deportes extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("action").equals("cargaTabla"))
            {
              DeporteRest elresdep=new DeporteRest();
              List<Deporte> respu=elresdep.findAll_JSON();
              SimpleDateFormat format=new SimpleDateFormat("dd-mm-yyyy");
              String cadenaDatos="";

             if(respu!=null){
             if(respu.size()>0)
             {
               for(int i=0;i<respu.size();i++)
               {
                   int posicion=(i+1);
                   String ini=format.format(respu.get(i).getFechaIni());
                   String term=format.format(respu.get(i).getFechaFin());
                    cadenaDatos=cadenaDatos+"<tr>";
                    cadenaDatos=cadenaDatos+"<td id=\"nom_"+posicion+"\"> "+respu.get(i).getNombre()+"</td>";
                    cadenaDatos=cadenaDatos+"<td id=\"ini_"+posicion+"\"> "+ini+" </td>";
                    cadenaDatos=cadenaDatos+"<td id=\"term_"+posicion+"\">"+term+"</td>";
                    cadenaDatos=cadenaDatos+"<td id=\"cupos_"+posicion+"\">"+respu.get(i).getCupos()+"</td>";
                    cadenaDatos=cadenaDatos+"<td id=\"cantCla_"+posicion+"\">"+respu.get(i).getTotalClases()+"</td>";
                    cadenaDatos=cadenaDatos+"<td><input type=\"hidden\" id=\"idDeporte_"+posicion+"\" value=\""+respu.get(i).getIdDeporte()+"\"><button type=\"button\" class=\"btn btn-warning\" onclick=\"editar("+posicion+");\"><i class=\"fa fa-pencil\"></i></button><button type=\"button\" class=\"btn btn-danger\" onclick=\"eliminar("+posicion+");\"><i class=\"fa fa-trash-o\"></i></button></td>";
                    cadenaDatos=cadenaDatos+"</tr>";

               }

            }
            }
              response.getWriter().write("//OK//"+cadenaDatos+"//");
                        
            }
        
    }
   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         if(request.getParameter("action").equals("eliminar"))
        {
            DeporteRest elRest=new DeporteRest(); 
            String idDeporte=request.getParameter("ElidDeporte");
            elRest.remove(idDeporte);
            elRest.close();
            response.getWriter().write("//OK//Se ha eliminado registro//");
            
            
        }
        else if(request.getParameter("action").equals("guardar"))
        {
        
        
                try {



                    SimpleDateFormat format=new SimpleDateFormat("dd-mm-yyyy");

                    if(request.getParameter("iddeporte").isEmpty())
                    {
                       
                        Deporte sport=new Deporte();
                        sport.setNombre(request.getParameter("nombre"));
                        sport.setCupos(Integer.parseInt(request.getParameter("cupos")));
                        Date fIni=format.parse(request.getParameter("inicio"));
                        Date fFn=format.parse(request.getParameter("termino"));
                        sport.setFechaIni(fIni);
                        sport.setFechaFin(fFn);
                        sport.setTotalClases(Integer.parseInt(request.getParameter("clases")));
                        DeporteRest elDep=new DeporteRest();
                        elDep.create_JSON(sport);
                        elDep.close();

                    }
                    else
                    {
                        Deporte sport=new Deporte();
                        sport.setIdDeporte(Integer.parseInt(request.getParameter("iddeporte")));
                        sport.setNombre(request.getParameter("nombre"));
                        sport.setCupos(Integer.parseInt(request.getParameter("cupos")));
                        Date fIni=format.parse(request.getParameter("inicio"));
                        Date fFn=format.parse(request.getParameter("termino"));
                        sport.setFechaIni(fIni);
                        sport.setFechaFin(fFn);
                        sport.setTotalClases(Integer.parseInt(request.getParameter("clases")));
                        DeporteRest elDep=new DeporteRest();
                        elDep.edit_JSON(sport,request.getParameter("iddeporte"));
                        elDep.close();
                        
                 }
                 request.getRequestDispatcher("deportes.jsp").forward(request, response);
                 
                } catch (ParseException ex) {
                    Logger.getLogger(controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
