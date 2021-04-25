/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engimon.model.inventory;

import com.engimon.model.engimon.Engimon;
import java.util.Comparator;

/**
 *
 * @author chris
 */
public class CompareEngimon implements Comparator<Engimon> {
        @Override
        public int compare(Engimon a, Engimon b) {
            return a.getName().compareTo(b.getName());
        }
    }
