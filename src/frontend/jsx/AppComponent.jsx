import React from 'react';
import Flexbox from 'flexbox-react';
import AppBar from 'material-ui/AppBar';
import {Tabs, Tab} from 'material-ui/Tabs';
import TextField from 'material-ui/TextField';
import RaisedButton from 'material-ui/RaisedButton';
import NavigationApps from 'material-ui/svg-icons/navigation/apps';
import ActionSettings from 'material-ui/svg-icons/action/settings';

const controlStyles = {
    marginLeft: "30px"
};

const AppComponent = () => (
    <div>
        <Flexbox marginLeft="10%" marginRight="10%" flexDirection="column" minHeight="100vw">

            <Flexbox flexDirection="column" marginBottom="10px">
                <AppBar title="Motor Vehicle Manager" />
                <Tabs>
                    <Tab icon={<NavigationApps />}>
                        <div>
                            <Flexbox marginTop="20px">
                                <TextField style={controlStyles} hintText="Enter name of owner" />
                                <TextField style={controlStyles} hintText="Enter name of vehicle" />
                                <RaisedButton label="OK" style={controlStyles} />
                            </Flexbox>
                        </div>
                    </Tab>
                    <Tab icon={<ActionSettings />}>
                        <div>
                            <p>My tab 3</p>
                        </div>
                    </Tab>
                </Tabs>
            </Flexbox>

        </Flexbox>
    </div>
);

export default AppComponent;