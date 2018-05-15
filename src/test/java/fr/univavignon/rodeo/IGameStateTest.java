package fr.univavignon.rodeo;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import fr.univavignon.rodeo.api.IGameState;

import fr.univavignon.rodeo.api.IAnimal;;


public class IGameStateTest {

	public static IAnimal animal = IAnimalTest.MockAnimal();
	public IGameState iGameState =MockGameState();
	
	public static IGameState  MockGameState() {
		
		IGameState iGameState = Mockito.mock(IGameState.class);
		
		Mockito.doThrow(new IllegalStateException()).when(iGameState).exploreArea();
		
		Mockito.doThrow(new IllegalArgumentException()).when(iGameState).catchAnimal(null);
		
		Mockito.doThrow(new IllegalStateException()).when(iGameState).catchAnimal(animal);
		
		return iGameState;
	}
	
	
	
	@Test
	public void testgetProgession(){
		
		when(iGameState.getProgression()).thenReturn(1);
		assertEquals(1, iGameState.getProgression());
	}
	
	

}