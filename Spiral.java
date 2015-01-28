import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
/*
 *  Coded and Tested on JDK 7.0
 */
public class Spiral {

	
 	public static void main(String[] args) {
 		List<String> lines = null;
 		int col_count = 0, row_count = 0;
 		try {
 			// we read the file from this location
			lines = Files.readAllLines(Paths.get("C://Developer//sample.txt"), Charset.defaultCharset());			
		} catch (IOException e) {
			e.printStackTrace();
		}

		// We calculate the row_count and col_count
		String [] temp = lines.get(0)!= null ? lines.get(0).split("\\|"): null;
		if (temp!= null)
			col_count = temp.length;
		row_count = lines.size();
		
		int[][] matrix = new int [lines.size()][col_count];
		for (int k = 0; k< lines.size(); k++)
		{
			String[] split = lines.get(k).split("\\|");
			for (int i=0; i<split.length; i++)
			{
				matrix[k][i] = Integer.parseInt(split[i]);
			}
		}
 		printInSpiralFormat(row_count,col_count, matrix);
	}
 	
	private static void printInSpiralFormat(int rowCount, int colCount, int[][] matrix) {
		int i, pointer_y = 0, pointer_x =0;
		
		rowCount--;
		colCount--;
		
		while (pointer_y <= rowCount && pointer_x <= colCount)
		{
			for (i=pointer_x; i<=colCount; ++i)
			{
				System.out.print(matrix[pointer_y][i]+",");
			}
			pointer_y++;
			
			for(i=pointer_y; i <= rowCount; ++i) 
			{
	            System.out.print(matrix[i][colCount]+",");
	        }
	        colCount--;

	        for(i=colCount; i >= pointer_x; --i) 
	        {
	            System.out.print(matrix[rowCount][i]+",");
	        }
	        rowCount--;

	        for(i=rowCount; i >= pointer_y; --i) 
	        {
	            System.out.print(matrix[i][pointer_x]+",");
	        }
	        pointer_x++;
		}
	}

}
