package cn.bingoogolapple.tuning;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:2017/7/28 上午9:24
 * 描述:
 */
public class ManualDemo {
    public static void main(String[] args) throws InterruptedException {
        new ManualDemo().doTest();
    }

    public void doTest() {
        // 单位, 兆(M)
        Integer M = new Integer(1024 * 1024);
        // 申请 1M 大小的内存空间
        byte[] bytes = new byte[1 * M];
        // 断开引用链
        bytes = null;
        // 手动触发 GC
        System.gc();
        System.out.println();
        // 重新申请 1M 大小的内存空间
        bytes = new byte[1 * M];
        // 再次申请 1M 大小的内存空间
        bytes = new byte[1 * M];
        // 手动触发 GC
        System.gc();
        System.out.println();
    }
}
