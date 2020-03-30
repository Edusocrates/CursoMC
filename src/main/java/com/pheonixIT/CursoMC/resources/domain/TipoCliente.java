package com.pheonixIT.CursoMC.resources.domain;

public enum TipoCliente {

    PESSOA_FISICA(1, "Pessoa Fisica"), PESSOA_JURIDICA(2, "Pessoa Juridica");

    private Integer cd;
    private String desc;

    public static TipoCliente toEnum(Integer cd) {
        if (cd == null) {
            return null;
        }
        for (TipoCliente x : TipoCliente.values()) {
            if (cd.equals(x.getCd())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id invalido");
    }


    TipoCliente(Integer cd, String desc) {
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
