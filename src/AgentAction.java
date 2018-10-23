
public  class AgentAction {
	
	 // if Pacman
	 /* private void pacmanRight(){
        grid[row][col]=" ";
        col++;

        if(pacmanAtGate()){
            row = 9;
            col= 0 ;
        }
        else if(pacmanAtBoundary()){
            col--;
        }
        else if(grid[row][col] == "."){
            coins++;
        }
        grid[row][col]=pacman;

    }
    private void pacmanLeft(){
        grid[row][col] =" ";
        col--;
        if(pacmanAtGate()){
            row = 9;
            col= 19;
        }
        else if(pacmanAtBoundary()){
            col++;
        }
        else if(grid[row][col] == "."){
            coins++;
        }
        grid[row][col] = pacman;
    }
    private void pacmanUp(){
        grid[row][col] = " ";
        row--;
        if(pacmanAtGate()){
            row = 19;
            col= 9 ;
        }
        else if(pacmanAtBoundary()){
            row++;
        }

        else if(grid[row][col] == "."){
            coins++;
        }

        grid[row][col] = pacman;
    }
    private void pacmanDown(){
        grid[row][col]=" ";
        row++;
        if(pacmanAtGate()){
            row =0;
            col=9;
        }
        else if(pacmanAtBoundary()){
            row--;
        }
        else if(grid[row][col] == "."){
            coins++;
        }
        grid[row][col] = pacman;
    }
    private boolean pacmanAtBoundary(){
        if(grid[row][col].equals("X"))
            return true;
        return false;
    }
*/
 //  if  fantome
	 /* private void ghostUp(){
        grid[ghostrow][ghostcol] = ".";
            ghostrow--;
        if(ghostAtGate()){
            ghostrow = 19;
            ghostcol= 9 ;
        }
        else if(ghostAtBoundary()){
            ghostrow++;
        }
        else if(grid[ghostrow][ghostcol].equals(" ")){
            grid[ghostrow][ghostcol] = " ";

        }
        grid[ghostrow][ghostcol] = ghost;

    }
    private void ghostDown(){
        grid[ghostrow][ghostcol] = ".";

            ghostrow++;
        if(ghostAtGate()){
            ghostrow = 0;
            ghostcol= 9 ;
        }
        else if(ghostAtBoundary()) {
            ghostrow--;
        }
        else if(grid[ghostrow][ghostcol].equals(" ")){
            grid[ghostrow][ghostcol] = " ";

        }
        grid[ghostrow][ghostcol] = ghost;

    }
    private void ghostLeft(){
        grid[ghostrow][ghostcol] = ".";

            ghostcol--;

        if(ghostAtGate()){
            ghostrow = 9;
            ghostcol= 19 ;
        }
        else if(ghostAtBoundary()){
            ghostcol++;
        }
        else if(grid[ghostrow][ghostcol].equals(" ")){
            grid[ghostrow][ghostcol] = " ";

        }
        grid[ghostrow][ghostcol] = ghost;

    }
    private void ghostRight(){
        grid[ghostrow][ghostcol] = ".";
            ghostcol++;
        if(ghostAtGate()){
            ghostrow = 9;
            ghostcol= 0 ;
        }
        else if(ghostAtBoundary()){
            ghostcol--;
        }
        else if(grid[ghostrow][ghostcol].equals(" ")){
            grid[ghostrow][ghostcol] = " ";

        }
        grid[ghostrow][ghostcol] = ghost;

    }
    private boolean ghostAtBoundary(){
        if(grid[ghostrow][ghostcol].equals("X")|| grid[ghostcol][ghostrow].equals("X"))
            return true;
        return false;
    }
    private boolean ghostAtGate(){
        if(ghostrow == 0 && ghostcol == 9){
            return true;
        }
        if(ghostrow == 9 && ghostcol == 0){
            return true;
        }
        if(ghostrow == 9 && ghostcol == 19){
            return true;
        }
        if(ghostrow == 19 && ghostcol == 9){
            return true;
        }
        return false;
    }
    private boolean ghostEatsPacman(){
        if(grid[row][col].equals(ghost) ){
            return true;
        }
        return false;
    }
*/











}
