$(document).ready(function () {
    $("tr #btnDelete").click(function () {
        var idp = $(this).parent().find("#idp").val();
        swal({
            title: "¿Está seguro de eliminar este producto?",
            text: "Una vez eliminado, podrá agregarlo nuevamente!",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        }).then((willDelete) => {
            if (willDelete) {
                eliminar(idp);
                swal("Listo! Producto eliminado del carrito!", {
                    icon: "success",
                }).then(willDelete => {
                    parent.location.href = "CestaServlet?op=Carrito";
                });
            } else {
                swal("¡No se eliminó el producto!");
            }
        });

    });

    function eliminar(idp) {
        var url = "CestaServlet?op=BorrarCarrito";
        $.ajax({
            type: 'POST',
            url: url,
            data: "idp=" + idp,
            success: function (data, textStatus, jqXHR) {
            },

        })
    }

    $("tr #Cantidad").click(function () {
        var idprod = $(this).parent().find("#idprod").val();
        var Cantidad = $(this).parent().find("#Cantidad").val();
        var url = "CestaServlet?op=ActualizarCantidad";
        $.ajax({
            type: 'POST',
            url: url,
            data: "idprod=" + idprod + "&Cantidad=" + Cantidad,
            success: function (data, textStatus, jqXHR) {
                location.href = "CestaServlet?op=Carrito";
            }
        });

    });
});





