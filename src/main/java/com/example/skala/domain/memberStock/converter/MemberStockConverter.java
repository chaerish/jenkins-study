package com.example.skala.domain.memberStock.converter;

import com.example.skala.domain.memberStock.dto.MemberStockResponseDTO;
import com.example.skala.domain.memberStock.entity.MemberStock;
import com.example.skala.domain.stock.entity.Stock;
import java.util.List;

public class MemberStockConverter {
    public static MemberStockResponseDTO.EachMyStockDTO convert(MemberStock memberStock) {
        Stock stock = memberStock.getStock();
        return new MemberStockResponseDTO.EachMyStockDTO(memberStock.getId(), stock.getStockName(),
                stock.getPrice() * memberStock.getQuantity(), memberStock.getQuantity());
    }

    public static MemberStockResponseDTO.AllMyStockDTO convert(List<MemberStock> memberStocks) {
        List<MemberStockResponseDTO.EachMyStockDTO> eachStocks = memberStocks.stream()
                .map(MemberStockConverter::convert).toList();
        return new MemberStockResponseDTO.AllMyStockDTO(eachStocks);
    }
}
