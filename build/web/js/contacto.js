function contactoUpd() {    
    var nro = $("input[name='nro_upd']:checked").val();
    if (isNaN(nro)) {
        alert("Seleccione Fila para Actualizar Datos");
    } else {
        window.location = "Contacto?accion=GET&nro=" + nro;
    }
}

function contactoDel() {
    var nros = [];
    $("input[name='nro_del']:checked").each(function () {
        nros.push($(this).val());
    });
    if (nros.length === 0) {
        alert("Advertencia\n\nSeleccione la(s) fila(s) a Retirar");
    } else {
        var exito = confirm('¿Seguro que deseas borrar los registros?');
        if (exito) {
            window.location = "Contacto?accion=DEL&nros=" + nros.toString();
        } else {
            alert("Operación cancelada");
        }
    }
}
