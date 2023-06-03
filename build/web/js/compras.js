function comprasDel() {
    var nros = [];
    $("input[name='compras_Del']:checked").each(function () {
        nros.push($(this).val());
    });
    if (nros.length === 0) {
        alert("Advertencia\n\nSeleccione la(s) fila(s) a Retirar");
    } else {
        var exito = confirm('¿Seguro que deseas borrar los registros?');
        if (exito) {
            window.location = "ComprasSrvt?accion=DEL&nros=" + nros.toString();
        } else {
            alert("Operación cancelada");
        }
    }
}

