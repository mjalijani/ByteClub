package com.game.byteclub.model.dowr

class Category(
    val name : String,
    var selected : Boolean){

    fun select(){
        selected = !selected
    }
}

