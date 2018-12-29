package par.mult;

import par.matrix.Matrix;

/**
 * Multiply a matrix sequentially.
 * 
 * @author YOU
 *
 */
public class SequentiallyMultiplier implements MatrixMultiplier {

	Matrix produkt;
	int i, ii, iii;

	public Matrix multiply(Matrix A, Matrix B) {
		int spaltem1 = A.getData().length;
		int zeilem2 = B.getData()[0].length;
		if (spaltem1 == zeilem2) {
			produkt = new Matrix(new int[A.getData()[0].length][B.getData().length]);
			for (i = 0; i < spaltem1; i++) {// Hier geht man durch die Zeilen

				for (ii = 0; ii < zeilem2; ii++) {// hier durch die Spalten

					for (iii = 0; iii < A.getData()[0].length; iii++) {
						/*
						 * Den 3. Index braucht man fuer die Multiplikation der 2 matritzen
						 */
							produkt.getData()[i][ii] += A.getData()[i][iii] * B.getData()[ii][iii];
					}
				}
			}
			return produkt;
		} else
			throw new IllegalArgumentException("Die Spalten von A muessen so lang wie die Zeilen von B sein!");

	}
	public static void main(String[] args) {
	int[][] a1 = new int[][] { { 3, 1 }, { 5, 6 } };
	int[][] a2 = new int[][] { { 2, 4 }, { 7, 8 } };
	Matrix m1 = new Matrix(a1);
	Matrix m2 = new Matrix(a2);
	System.out.println(new ParallelMultiplier().multiply(m1, m2));
	}
}
