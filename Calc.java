interface Calc {
    /*
     * Fez necessário mudar o tipo do retorno devido os atributos numericos ser int ou float
     * mantento assim o tipo mais amplo (float) sem que haja perca ao invés do int
     */
    float calcular();
}
