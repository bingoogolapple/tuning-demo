package cn.bingoogolapple.tuning;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:2017/7/27 下午11:04
 * 描述:
 */
public class Product {
    private String name;
    private byte[] extSize;

    public Product(String name, int objectSize) {
        this.name = name;
        this.extSize = new byte[objectSize];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getExtSize() {
        return extSize;
    }

    public void setExtSize(byte[] extSize) {
        this.extSize = extSize;
    }
}
