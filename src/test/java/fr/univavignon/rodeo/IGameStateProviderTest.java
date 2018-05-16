package fr.univavignon.rodeo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doThrow;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import fr.univavignon.rodeo.api.IAnimal;

import fr.univavignon.rodeo.api.IGameState;
import fr.univavignon.rodeo.api.IGameStateProvider;
import fr.univavignon.rodeo.api.ISpecie;

public class IGameStateProviderTest {
			
	public static IGameStateProvider gameStateProvider;		
	
	public static IGameState gameState;	
				
		    public static  IGameStateProvider mockGameStateProvider(){		    	
		    
		        gameStateProvider=Mockito.mock(IGameStateProvider.class);		        
		        Mockito.doThrow(new IllegalArgumentException()).when(gameStateProvider).get(null);
		        gameState = IGameStateTest.mockGameState();			        
		        Mockito.when(gameStateProvider.get("nothink")).thenReturn(gameState);        
		        
		        return gameStateProvider;		        
		 }  
		    
		    
		    @Before  
		    public void initialisation(){
		    	
		    	gameStateProvider= mockGameStateProvider();
		   	 
		    }
	
		    
		    
		    @Test(expected=IllegalArgumentException.class)
			public void testGetExcep(){
				
		    	gameStateProvider.get(null);
				
		    }
	
	
		    @Test
			public void testGet(){
				
				assertEquals(gameState, gameStateProvider.get("nothink"));
				
		    }


}