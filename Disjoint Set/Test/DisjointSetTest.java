import org.junit.Assert;
import org.junit.Test;

public class DisjointSetTest {

    @Test
    public void create() {
        DisjointSet ds = new DisjointSet(10);
        int[] parent = ds.getParent();
        int[] rank = ds.getRank();

        Assert.assertEquals(10, parent.length);
        Assert.assertEquals(10, rank.length);

        for (int i = 0; i < parent.length; i++) {
            Assert.assertEquals(i, parent[i]);
            Assert.assertEquals(0, rank[i]);
        }
    }

    @Test
    public void makeSet() {
        DisjointSet ds = new DisjointSet(10);
        ds.setParent(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        ds.setRank(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0});

        for (int i = 0; i < 10; i++) {
            ds.makeSet(i);
        }

        Assert.assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, ds.getParent());
        Assert.assertArrayEquals(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, ds.getRank());
    }

    @Test
    public void find() {
        DisjointSet ds = new DisjointSet(10);
        ds.setParent(new int[]{0, 0, 1, 2, 3, 4, 5, 6, 7, 9});
        ds.setRank(new int[]{8, 7, 6, 5, 4, 3, 2, 1, 0, 0});

        Assert.assertEquals(9, ds.find(9));
        for (int i = 0; i < 9; i++) {
            Assert.assertEquals(0, ds.find(i));
        }
        Assert.assertArrayEquals(new int[]{0, 0, 1, 2, 3, 4, 5, 6, 7, 9}, ds.getParent());
        Assert.assertArrayEquals(new int[]{8, 7, 6, 5, 4, 3, 2, 1, 0, 0}, ds.getRank());
    }

    @Test
    public void findWithPathCompression() {
        DisjointSet ds = new DisjointSet(10);
        ds.setParent(new int[]{0, 0, 1, 2, 3, 4, 5, 6, 7, 9});
        ds.setRank(new int[]{8, 7, 6, 5, 4, 3, 2, 1, 0, 0});

        Assert.assertEquals(9, ds.findWithPathCompression(9));
        for (int i = 0; i < 9; i++) {
            Assert.assertEquals(0, ds.findWithPathCompression(i));
        }
        Assert.assertArrayEquals(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 9}, ds.getParent());
        Assert.assertArrayEquals(new int[]{8, 7, 6, 5, 4, 3, 2, 1, 0, 0}, ds.getRank());
    }

    @Test
    public void union() {
        DisjointSet ds = new DisjointSet(7);
        ds.union(2, 4);
        ds.union(5, 2);
        ds.union(3, 1);
        ds.union(2, 3);
        ds.union(2, 6);

        Assert.assertArrayEquals(new int[]{0, 1, 4, 1, 1, 4, 1}, ds.getParent());
        Assert.assertArrayEquals(new int[]{0, 2, 0, 0, 1, 0, 0}, ds.getRank());
    }

}