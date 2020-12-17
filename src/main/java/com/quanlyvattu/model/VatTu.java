package com.quanlyvattu.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class VatTu {
    @Id
    private String maVT;

    private String MaKKS;

    @NotNull
    private String TenVT;

    private String DVTinh;

    @ManyToOne
    private NCC ncc;

    @ManyToOne
    private Nuoc nuoc;


}
