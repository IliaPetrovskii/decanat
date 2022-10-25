package com.petrovskii.decanat.service;

import com.petrovskii.decanat.entity.SheetPass;

public interface SheetPassService {
    Iterable<SheetPass> findAllByGroup(String group);
}
