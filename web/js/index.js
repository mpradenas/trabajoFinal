$(function(){
    $.get("controlador",
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
    var apellido=$("#aps_"+pos).html();
    var fecha=$("#fechaNac_"+pos).html();
    var rut=$("#rut_"+pos).html();
    var idest=$("#idEstudiante_"+pos).val();
    $("#nombre").val(nombre);
    $("#apellidos").val(apellido);
    $("#rut").val(rut);
    $("#fecha").val(fecha);
    $("#idEstudiante").val(idest);
    $("#guardar").html("Modificar");
    $("#cancelar").show();
    
}

function cancelarEdicion()
{
    $("#nombre").val("");
    $("#apellidos").val("");
    $("#rut").val("");
    $("#fecha").val("");
    
    $("#idEstudiante").val("");
    $("#guardar").html("Guardar");
    $("#cancelar").hide();
}
function eliminar(posicion)
{
    var idEstudiante=$("#idEstudiante_"+posicion).val();
    
    $.post("controlador",
    {
        action:"eliminar",Elidestudiante:idEstudiante
    },function(data)
    {
        data=data.split("//");
        if(data[1]=="OK")
        {
            alert(data[2]);
            location.href="index.jsp";
        }
        else
        {
            alert(data[2]); 
        }
    })
}

