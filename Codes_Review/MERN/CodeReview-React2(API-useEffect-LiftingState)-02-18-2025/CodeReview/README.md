## Overview

This project is a simple React application that displays a list of characters from the Rick and Morty API. Users can select a character from the list to view more details about them.

## Tasks to follow in our code review session

2. **Create components:**
   - Create a `CharactersList` component to display the list of characters.
   - Create a `CharacterDetails` component to display details of the selected character.

3. **Fetch data from the API:**
   - API : https://rickandmortyapi.com/api/character
   - Fetch data from the Rick and Morty API when the component mounts.
   - Store the fetched data in the component's state.

4. **Lift state up:**
   - Manage the state of the selected character in the parent component (`App`).
   - Pass the state and state updater function as props to the child components (`CharactersList` and `CharacterDetails`).

5. **Render the components:**
   - Render the `CharactersList` and `CharacterDetails` components in the `App` component.
   - Pass the necessary props to the child components.

6. **Add input to limit characters:**
   - Add an input field in the `CharactersList` component to allow users to specify the number of characters to display.
   - Update the state and limit the number of characters displayed based on the input value.

## What we used in this project

- **Axios:** A promise-based HTTP client for making API requests.
- **API:** An open API that provides information about characters, episodes, and locations from the Rick and Morty TV show.
- **useEffect Hook:** A React hook that allows you to perform side effects in function components.
- **useState Hook:** A React hook that allows you to add state to function components.
- **Lifting State:** A pattern where the state is moved up to the closest common ancestor of the components that need to share the state.

