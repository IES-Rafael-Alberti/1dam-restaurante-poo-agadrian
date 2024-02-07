class SistemaGestionRestaurante(private val mesas: List<Mesa>) {

    /**
     * Asocia un nuevo pedido a una mesa. Debe verificar que la mesa esté ocupada antes de asociar el pedido.
     * @param numeroMesa Numero de la mesa que realiza el pedido
     * @param pedido El pedido a realizar, de la clase Pedido
     */
    fun realizarPedido(numeroMesa: Int, pedido: Pedido) {
        val mesa = mesas.find { it.numero == numeroMesa }
        if (mesa != null && mesa.estado == EstadoMesa.Ocupada){
            mesa.agregarPedido(pedido)
        }
    }


    /**
     * Si el númeroPedido es null, cambia el estado del último pedido de una mesa a "servido". Si le llega un numeroPedido, entonces debe buscar el pedido con dicho número y cambiar su estado a "servido".
     * @param numeroMesa Numero de la mesa donde se ecnuentra el pedido
     * @param numeroPedido Numero del pedido a cerrar. Si es null, se cerrará el último pedido de la mesa.
     */
    fun cerrarPedido(numeroMesa: Int, numeroPedido: Int? = null) {
        val mesa = mesas.find { it.numero == numeroMesa }
        //TODO
    }


    /**
     * Libera una mesa si todos los pedidos están servidos.
     * @param numeroMesa Número de la mesa a liberar.
     */
    fun cerrarMesa(numeroMesa: Int) {
        //TODO desarrollar este método...
    }


    /**
     * Retorna una lista con el nombre de los platos pedidos.
     * Si no hay platos pedidos, retorna null.
     * @return Lista de nombres de platos pedidos.
     */
    fun buscarPlatos(): List<String>? {
        val platos = mesas.flatMap { it.pedidos }.flatMap { it.platos }.map { it.nombre }
        return platos.ifEmpty { null }
    }


    /**
     * Cuenta el número de veces que se ha pedido un plato.
     * Si el plato no ha sido pedido, retorna null.
     * @param nombre Nombre del plato a contar.
     * @return Número de veces que se ha pedido el plato.
     */
    fun contarPlato(nombre: String): Int? {
        val count = mesas.flatMap { it.pedidos }
            .flatMap { it.platos }
            .count { it.nombre == nombre }
        return if (count > 0) count else null
    }


    /**
     * Busca y retorna el o los platos más pedidos.
     * Si no hay platos pedidos, retorna null.
     * @return Lista con el nombre del o los platos más pedidos.
     */
    fun buscarPlatoMasPedido(): List<String>? {
        val platoCounts = mesas.flatMap { it.pedidos }
            .flatMap { it.platos }
            .groupingBy { it.nombre }
            .eachCount()

        val maxCount = platoCounts.maxByOrNull { it.value }?.value
        return maxCount?.let { max -> platoCounts.filter { it.value == max }.keys.toList() }
    }


}