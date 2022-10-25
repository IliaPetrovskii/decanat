package com.petrovskii.decanat.service;

import com.petrovskii.decanat.entity.SheetPass;
import com.petrovskii.decanat.repository.SheetPassRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SheetPassServiceImpl implements SheetPassService{
    private final SheetPassRepository sheetPassRepository;

    @Override
    public Iterable<SheetPass> findAllByGroup(String group){
        return sheetPassRepository.findAllByGroup(group);
    }
}
