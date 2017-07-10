$(document).ready(function(){
    

    
    
    $.get("inscripciones",
    { action:"cargaTabla" },
    function(data)
    {
        data=data.split("//");
        if(data[1]=="OK")
        {
            $("#laTabla").html(data[2]);
            $("#iddeporte").html(data[3]);
            
        }
    });
    
   $(".datepicker" ).datepicker({
       dateFormat: 'dd-mm-yy'
   });
   
   $("#dialogBuscaAlumnos").dialog({
       title:"Buscador de alumnos",
       autoOpen : false,
       resizable: false,
       width:700,
       height:500,
       buttons:[
           {
              text:"aceptar",
              "class":"btn btn-primary",
              click:function()
              {
                  var posicion=$("[name='estudents']:checked").val();
                  var nombre=$("#nomEst_"+posicion).html()+" "+$("#apEst_"+posicion).html();
                  var idEstudiante=$("#idEstu_"+posicion).val();
                  
                  $("#idestudiante").val(idEstudiante);
                  $("#nombre").val(nombre);
                  $(this).dialog('close');
              }
           },
           {
              text:"cancelar",
              "class":"btn btn-default",
              click:function()
              {
                  $(this).dialog('close');
              }
           }
       ]
       
   });
    
    
    
});

function editar(pos)
{
    var nombre=$("#nom_"+pos).html();
    var cantAsist=$("#clasesAsistidas_"+pos).html();
    var idEst=$("#idEstudiante_"+pos).val();
    var idDep=$("#iddeporte_"+pos).val();
    var idIns=$("#idInscrip_"+pos).val();
    
    
    $("#nombre").val(nombre);
    $("#idinscripcion").val(idIns);
    $("#idestudiante").val(idEst);
    $("#iddeporte").val(idDep);
    $("#clasesAsistidas").val(cantAsist);
    
    
    $("#guardar").html("Modificar");
    $("#cancelar").show();
    
}

function cancelarEdicion()
{
     
    $("#nombre").val("");
    $("#idinscripcion").val("");
    $("#idestudiante").val("");
    $("#iddeporte").val("");
    $("#clasesAsistidas").val("");
   
    $("#guardar").html("Guardar");
    $("#cancelar").hide();
}
function eliminar(posicion)
{
    var idInscripcion=$("#idInscrip_"+posicion).val();
    
    $.post("inscripciones",
    {
        action:"eliminar",ElidInscripcion:idInscripcion
    },function(data)
    {
        data=data.split("//");
        if(data[1]=="OK")
        {
            alert(data[2]);
            location.href="inscripciones.jsp";
        }
        else
        {
            alert(data[2]); 
        }
    })
}

function buscaAlumnos()
{
    $("#dialogBuscaAlumnos").dialog('open');
}

function buscaListaAlumnos()
{
    $.get("inscripciones",
    { action:"cargaTablaAlumnos" },
    function(data)
    {
        data=data.split("//");
        if(data[1]=="OK")
        {
            $("#tablaAlumnos").html(data[2]);
           
        }
    });
    
}