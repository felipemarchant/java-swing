enum MenuEscolha {
    CADASTRAR_VEICULO_PASSEIO(1, "Cadastrar Veículo de Passeio"),
    CADASTRAR_VEICULO_CARGA(2, "Cadastrar Veículo de Carga"),
    IMPRIMIR_TODOS_VEICULOS_PASSEIO(3, "Imprimir Todos os Veículos de Passeio"),
    IMPRIMIR_TODOS_VEICULOS_CARGA(4, "Imprimir Todos os Veículos de Carga"),
    IMPRIMIR_VEICULO_PASSEIO_PELA_PLACA(5, "Imprimir Veículo de Passeio pela Placa"),
    IMPRIMIR_VEICULO_CARGA_PELA_PLACA(6, "Imprimir Veículo de Carga pela Placa"),
    EXCLUIR_VEICULO_DE_PASSEIO_PELA_PLACA(7, "Excluir Veículo de Passeio pela Placa"),
    EXCLUIR_VEICULO_DE_CARGA_PELA_PLACA(8, "Excluir Veículo de Carga pela Placa"),
    SAIR_DO_SISTEMA(9, "Sair do sistema");

    public final String LABEL;
    public final int ID;

    MenuEscolha(int id, String label) {
        this.ID = id;
        this.LABEL = label;
    }
}