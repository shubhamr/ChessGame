# ChessGame
**Java Chess Game**

Classes Used: 

**Game**  -> *encapsulates Board, Players, Main class*<br>
**Board** -> *logical representation of chess board, holds 8 * 8 matrix of Tiles*<br>
**Tile**  ->  *each cell/tile in the chess board , holds its xth and yth position, reference to board and the piece its holding if any*<br>

**Player** -> *abstract class to represent players*<br>
HumanPlayer, ComputerPlayer<br>

**Piece** <br>
 1. *abstract class to represent pieces in chess (types -> Rook, Knight, Bishop, Queen, King, Pawn)*  
 2. *each of the classes define their own legalMoves based on the type of movement they can do*
 3. *common method to get linearPossibleMoves(horizontal and vertical)*
 4.  *common method to get diagnolPossibleMoves*
 
 
<br>

**Possible Future Enhancements:** 

 1. CheckMateEngine 
 2. GUI Interface

