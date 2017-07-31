package com.vvygulyarniy.wowcraft.marketprice;

import lombok.Data;

import java.util.List;

@Data
public class MainResponse {

    private final List<FileInfo> files;

    @Data
    static class FileInfo {
        private final String url;
        private final Long lastModified;
    }

}
