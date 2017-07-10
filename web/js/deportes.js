$(document).ready(function(){
    $.get("deportes",
    { action:"cargaTabla" },
    function(data)
    {
        data=data.split("//");
        if(data[1]=="OK")
        {
            $("#laTabla").html(data[2]);
        }
    });
    
   $(".datepicker" ).datepicker({
       dateFormat: 'dd-mm-yy'
    });
    
});

function editar(pos)
{
    var nombre=$("#nom_"+pos).html();
    var ini=$("#ini_"+pos).html();
    var term=$("#term_"+pos).html();
    var cupos=$("#cupos_"+pos).html();
    var cantCla=$("#cantCla_"+pos).html();
    var idDep=$("#idDeporte_"+pos).val();
    $("#nombre").val(nombre);
    $("#inicio").val(ini);
    $("#termino").val(term);
    $("#cupos").val(cupos);
    $("#clases").val(cantCla);
    $("#iddeporte").val(idDep);
    $("#guardar").html("Modificar");
    $("#cancelar").show();
    
}

function cancelarEdicion()
{
    $("#nombre").val("");
    $("#inicio").val("");
    $("#termino").val("");
    $("#cupos").val("");
    $("#clases").val("");
    $("#iddeporte").val("");
    $("#guardar").html("Guardar");
    $("#cancelar").hide();
}
function eliminar(posicion)
{
    var idDeporte=$("#idDeporte_"+posicion).val();
    
    $.post("deportes",
    {
        action:"eliminar",ElidDeporte:idDeporte
    },function(data)
    {
        data=data.split("//");
        if(data[1]=="OK")
        {
            alert(data[2]);
            location.href="deportes.jsp";
        }
        else
        {
            alert(data[2]); 
        }
    })
}