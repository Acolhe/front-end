package com.acolhe.app.model;

import java.util.List;

public class ClinicasDTO {
    private static List<Clinica> clinicas;

    public ClinicasDTO(List<Clinica> model) {
        ClinicasDTO.clinicas = model;
    }

    public static List<Clinica> getClinicas() {
        return clinicas;
    }

    public static void setClinicas(List<Clinica> clinicas) {
        ClinicasDTO.clinicas = clinicas;
    }
}
