class Cliente (val nome: String, val sobrenome: String, val idade: Int)
class Venda(val cliente: Cliente, val emitente: Emitente, val indicadorDePresenca: Boolean, val itensDaVenda: MutableList<ItemDaVenda>)
class ItemDaVenda (val nome: String, val preco: Double)
class Emitente {
    val nome: String
    val cnpj: String

    constructor(nome: String, cnpj: String) {
        this.nome = nome.takeIf { nome.isNullOrEmpty() } ?: "Não identificado"
        this.cnpj = cnpj
    }

    constructor(nome: String){
        this.nome = nome
        this.cnpj = ""
    }
}

fun main() {
    val cliente = Cliente("Matheus", "Brenner", 25)

    val emitente = Emitente("Hiper Software SA", "12.605.982.0001-24")

    val itens: MutableList<ItemDaVenda> = mutableListOf()
    itens.add(ItemDaVenda("Sabonete", 1.50))
    itens.add(ItemDaVenda("Pão", 0.50))

    val venda = Venda(cliente, emitente, false, itens)

    println("--------------------------------------------------")
    println("Cliente: ${venda.cliente.nome} ${venda.cliente.sobrenome}")
    println("Emitente: ${venda.emitente.nome} - CNPJ (${venda.emitente.cnpj})")
    println("Indicador de presença: ${if(venda.indicadorDePresenca) "Operação presencial" else "Operação não presencial"}")
    println("--------------------------------------------------")

    var numeroDoItem: Int = 1
    for(item in itens){
        println("Item $numeroDoItem:")
        println("- Nome do item: " + item.nome)
        println("- Preço do item: " + item.preco)
        println()
        numeroDoItem++
    }
    println("--------------------------------------------------")

}