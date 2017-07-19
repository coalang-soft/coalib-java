package io.github.coalangsoft.lib.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Tool to copy an input streams values to an output stream.
 */
public class StreamCopy {
	
	/**
	 * Copies the values from an input stream to an output stream.
	 * @param in the input stream to copy from.
	 * @param out the output stream to copy to.
	 * @throws IOException if something went wrong.
	 */
	public static void copy(InputStream in, OutputStream out) throws IOException {
        try {
            byte[] buf = new byte[1024];
            int len;
            while((len=in.read(buf))>0){
                out.write(buf,0,len);
            }
        }
        catch (IOException e) {
            throw e;
        }
        finally {
            // Ensure that the InputStreams are closed even if there's an exception.
            try {
                if ( out != null ) {
                    out.close();
                }

                // If you want to close the "in" InputStream yourself then remove this
                // from here but ensure that you close it yourself eventually.
                in.close();
            }
            catch ( IOException e ) {
                e.printStackTrace();
            }
        }
    }
	
}
