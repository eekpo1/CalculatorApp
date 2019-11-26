package model

enum class Operation(val type: Char, val priority: Int) {
    ADD('+', 1), SUBTRACT('-', 1), MULTIPLY('*', 2), DIVIDE('/', 2), POWER('^', 3), SQRT('√', 3),
    COS('@', 4), SIN('#', 4), E('e', 4), LN('l', 4), TAN('t', 4);
}