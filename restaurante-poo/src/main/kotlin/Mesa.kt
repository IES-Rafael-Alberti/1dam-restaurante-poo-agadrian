class Mesa(val numero: Int, val capacidad: Int, var estado: EstadoMesa, val pedidos: MutableList<Pedido> ) {


    /**
     *  Cambia el estado de la mesa a "ocupada", pero solo si la mesa está en estado "libre".
     */
    fun ocuparMesa(){
        if (estado == EstadoMesa.Libre){
            estado = EstadoMesa.Ocupada
        }
    }


    /**
     * Cambia el estado de la mesa a "ocupada", pero solo si la mesa está en estado "reservada".
     */
    fun ocuparReserva(){
        if (estado == EstadoMesa.Reservada){
            estado = EstadoMesa.Ocupada
        }
    }


    /***
     * Cambia el estado de la mesa a "libre".
     */
    fun liberarMesa(){
        estado = EstadoMesa.Libre
    }


    /**
     * Agrega un pedido a los pedidos de la mesa.
     */
    fun agregarPedido(pedido: Pedido){
        pedidos.add(pedido)
    }



}