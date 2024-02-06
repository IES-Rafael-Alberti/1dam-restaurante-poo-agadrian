/**
 * Representa la información de un plato.
 * @param nombre: String - El nombre del plato. No puede ser vacío.
 * @param precio: Double - El precio del plato. Debe ser mayor que 0.
 * @param tiempoPreparacion: Int - Tiempo estimado para preparar el plato (en minutos).
 * @param ingredientes: List - Lista de ingredientes necesarios para el plato.
 */
class Plato(nombre: String, precio: Double, tiempoPreparacion: Int, ingredientes: MutableList<String>) {

    // Seters de las propiedades
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

    var tiempoPreparacion: Int = tiempoPreparacion
        set(value) {
            field = value
            requireTiempoPrep()
        }

    var ingredientes: MutableList<String> = ingredientes
        set(value) {
            field = value
            requireIngrediente()
        }

    // Realizar comprobaciones al crear un objeto
    init {
        requireNombre()
        requirePrecio()
        requireTiempoPrep()
        requireIngrediente()
    }


    /**
     * Agrega un nuevo ingrediente a la lista de ingredientes del plato.
     * @param ingrediente El ingrediente a agregar.
     */
    fun agregarIngrediente(ingrediente: String){
        this.ingredientes.add(ingrediente)
    }

    /**
     * Representación del plato en forma de cadena de texto.
     * @return Cadena de caracteres con la informacion del plato
     */
    override fun toString():String {
        return "${this.nombre} ($tiempoPreparacion min.) -> $precio€ (${this.ingredientes.joinToString {it} })"
    }


    //Funciones reusables Requires

    fun requireNombre(){
        require (this.nombre.isNotBlank()) {"El nombre no puede estar vacio."}
    }

    fun requirePrecio(){
        require (this.precio > 0) {"El precio debe ser mayor a 0."}
    }

    fun requireTiempoPrep(){
        require (this.tiempoPreparacion > 1) {"El tiempo de preparacion debe ser mayor a 1 min."}
    }

    /**
     * Lanza un require si al filtrar la lista de ingredientes por notBlank, la nueva lista creada no tiene el mismo size que la original (hay elementos vacios o con espacios)
     */
    fun requireIngrediente(){
        require (this.ingredientes.filter { it.isNotBlank() }.size == this.ingredientes.size) {"No puede haber ingrediente vacio."}
    }

}