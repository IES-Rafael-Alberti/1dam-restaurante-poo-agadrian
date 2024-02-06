/**
 * Representa la información de un plato.
 * @param nombre: String - El nombre del plato. No puede ser vacío.
 * @param precio: Double - El precio del plato. Debe ser mayor que 0.
 * @param tiempoPreparacion: Int - Tiempo estimado para preparar el plato (en minutos).
 * @param ingredientes: List - Lista de ingredientes necesarios para el plato.
 */
class Plato(nombre: String, precio: Double, val tiempoPreparacion: Int, val ingredientes: MutableList<String>) {

    var nombre: String = nombre
        set(value) {
            field = value
            requireNombre()
        }

    var precio: Double = precio
        set(value) {
            field = value
            requirePrecio()

        }


    init {
        requireNombre()
        requirePrecio()
    }


    fun agregarIngrediente(ingrediente: String){
        this.ingredientes.add(ingrediente)
    }

    override fun toString():String {
        return "${this.nombre} ($tiempoPreparacion min.) -> $precio€ (${this.ingredientes.joinToString {it} })"
    }

    fun requireNombre(){
        require (nombre.isNotBlank()) {"El nombre no puede estar vacio"}
    }

    fun requirePrecio(){
        require (precio > 0) {"El precio debe ser mayor a 0"}
    }

}