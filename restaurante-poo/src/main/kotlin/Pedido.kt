class Pedido (private val numero: Int = contPedidos++){
    companion object{
        var contPedidos = 0
    }

    val platos: MutableList<Plato> = mutableListOf()

    val estado: EstadoPedido = EstadoPedido.Pendiente


    /**
     * Añade un nuevo plato al pedido.
     * @param plato Objeto de clase Plato, que sera añadido a la lista
     */
    fun agregarPlato(plato: Plato){
        this.platos.add(plato)
    }


    /**
     * Elimina un plato del pedido basándose en el nombre.
     * @param nombrePlato Nommbre del plato a eliminar
     */
    fun eliminarPlato(nombrePlato: String){
        platos.removeIf{ it.nombre == nombrePlato } // Reemplaza directamente en la lista original
        // platos.removeAll {it.nombre == nombrePlato}  // crea una lista nueva y la reemplaza
    }

    /**
     * Calcula el precio total del pedido sumando los precios de cada plato
     */
    fun calcularPrecio():Double {
        var sumaPrecio = 0.0
        platos.forEach{sumaPrecio += it.precio}
        return sumaPrecio
    }


    /**
     * Calcula el tiempo total de preparación sumando el tiempo de preparación de cada plato.
     */
    fun calcularTiempo(): Int{
        var sumaTiempo = 0
        platos.forEach{sumaTiempo += it.tiempoPreparacion}
        return sumaTiempo
    }

    // TODO: Acabar tostring
    /**
     * Retornar la información del pedido utilizando el número de mesa, el método toString() de cada plato y su estado.
     */
    override fun toString(): String {
        return ""
    }

}