package com.bulldozer.domain.site;

public abstract class SiteFactory {
    public static Site createSite(String[][] inputMap) {
        ClearableBlock[][] siteMatrix = new ClearableBlock[inputMap.length][inputMap[0].length];
        for (int y = 0; y < inputMap.length; y++) {
            for (int x = 0; x < inputMap[0].length; x++) {
                String s = inputMap[y][x];
                ClearableBlock block;
                switch (s) {
                    case "o":
                        block = new SiteBlock(SiteBlock.PLAIN);
                        break;
                    case "r":
                        block = new SiteBlock(SiteBlock.ROCK);
                        break;
                    case "t":
                        block = new SiteBlock(SiteBlock.TREE);
                        break;
                    case "T":
                        block = new SiteBlock(SiteBlock.PROTECTED_TREE);
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported block type: " + s);
                }
                siteMatrix[y][x] = block;
            }
        }

        return new Site(siteMatrix);
    }
}
