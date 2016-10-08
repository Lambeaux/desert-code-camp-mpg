import React from 'react';
import {render} from 'react-dom';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import AppComponent from './AppComponent.jsx'
import injectTapEventPlugin from 'react-tap-event-plugin';

injectTapEventPlugin();

const App = () => (
    <MuiThemeProvider>
        <AppComponent />
    </MuiThemeProvider>
);

render(<App/>, document.getElementById('app'));