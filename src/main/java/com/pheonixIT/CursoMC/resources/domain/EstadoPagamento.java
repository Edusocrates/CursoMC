package com.pheonixIT.CursoMC.resources.domain;

public enum EstadoPagamento {

    PENDENTE(1,"Pendente"),
    QUITADO(2,"Quitado"),
    CANCELADO(3,"Cancelado");

    private Integer cd;
    private String desc;

    public static EstadoPagamento toEnum(Integer cd) {
        if (cd == null) {
            return null;
        }
        for (EstadoPagamento x : EstadoPagamento.values()) {
            if (cd.equals(x.getCd())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id invalido");
    }


    EstadoPagamento(Integer cd, String desc) {
        this.cd = cd;
        this.desc = desc;
    }

    public Integer getCd() {
        return cd;
    }

    public String getDesc() {
        return desc;
    }

}
