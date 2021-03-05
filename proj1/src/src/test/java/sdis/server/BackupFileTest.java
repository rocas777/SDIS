package sdis.server;

import junit.framework.TestCase;

public class BackupFileTest extends TestCase {

    public void testAddChunk() {
        BackupFile f = new BackupFile("12345");
        f.addChunk(2,"teste");
        assertEquals("12345",f.getChunks().get(0).getFileID());
        assertEquals(2,f.getChunks().get(0).getChunkNo());
        assertEquals("teste",f.getChunks().get(0).getFileName());
    }

    public void testGetChunk1() {
        BackupFile f = new BackupFile("12345");
        f.addChunk(2,"teste");

        try {
            assertEquals("teste",f.getChunk(2).getFileName());
            assertEquals("12345",f.getChunk(2).getFileID());
            assertEquals(2,f.getChunk(2).getChunkNo());
        } catch (ChunkNotFound chunkNotFound) {
            chunkNotFound.printStackTrace();
        }
    }
    public void testGetChunk2() {
        BackupFile f = new BackupFile("12345");
        try {
            assertEquals("teste",f.getChunk(2).getFileName());
            assertEquals("12345",f.getChunk(2).getFileID());
            assertEquals(2,f.getChunk(2).getChunkNo());
            fail();
        } catch (ChunkNotFound chunkNotFound) {

        }
    }
}