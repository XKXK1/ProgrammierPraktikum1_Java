package aufgabenblatt6;

/**
 * 
 * OfflineSendungsdauerSchaetzer hat alle Sendungsdauern in einem zweidimensionalen Array zur verfuegung
 *
 */

public class OfflineSendungsdauerSchaetzer implements SendungsdauerSchaetzer {
	int sendungsdauer[][] = { { 0, 172, 320, 333, 310, 354, 324, 284, 305, 226 },
			{ 170, 0, 422, 249, 283, 376, 233, 200, 214, 77 }, { 320, 423, 0, 325, 233, 141, 354, 344, 363, 406 },
			{ 329, 249, 323, 0, 118, 214, 42, 70, 62, 189 }, { 311, 283, 230, 118, 0, 130, 146, 140, 157, 260 },
			{ 352, 376, 144, 214, 131, 0, 243, 245, 254, 359 }, { 323, 236, 351, 42, 146, 241, 0, 56, 35, 177 },
			{ 283, 202, 345, 72, 142, 246, 55, 0, 31, 143 }, { 306, 217, 362, 62, 157, 253, 35, 34, 0, 158 },
			{ 227, 79, 407, 193, 264, 361, 177, 144, 158, 0 } };

	/**
	 * Dient als Uebersetzung zwischen Nutzer mit Stadtnameneingabe und dem
	 * Array, welches nur zahlen versteht.
	 */
	@Override
	public int getSendungsTransportDauer(Staedte senderOrt, Staedte empfaengerOrt) {
		return sendungsdauer[senderOrt.ordinal()][empfaengerOrt.ordinal()];
	}

	// public static void main(String [] args){
	// GoogleSendungsdauerSchaetzer sendung = new
	// GoogleSendungsdauerSchaetzer();
	//
	// for(int i=0; i<Staedte.values().length;i++){
	// System.out.println("");
	// for(int j=0; j<Staedte.values().length;j++){
	// Staedte stadt1 = Staedte.values()[i];
	// Staedte stadt2 = Staedte.values()[j];
	// System.out.print(sendung.getSendungsTransportDauer(stadt1, stadt2)+", ");
	//
	// }
	//
	// }
	// }
}
