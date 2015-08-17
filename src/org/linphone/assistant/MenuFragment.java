package org.linphone.assistant;
/*
MenuFragment.java
Copyright (C) 2012  Belledonne Communications, Grenoble, France

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
*/
import org.linphone.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * @author Sylvain Berfini
 */
public class MenuFragment extends Fragment implements OnClickListener {
	private Button createAccount, logLinphoneAccount, logGenericAccount, remoteProvisioning;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.assistant_menu, container, false);
		
		createAccount = (Button) view.findViewById(R.id.setup_create_account);
		createAccount.setOnClickListener(this);
		
		logLinphoneAccount = (Button) view.findViewById(R.id.setup_login_linphone);
		if (getResources().getBoolean(R.bool.hide_linphone_accounts_wizard)) {
			view.findViewById(R.id.setup_login_linphone_layout).setVisibility(View.GONE);
		} else {
			logLinphoneAccount.setOnClickListener(this);
		}
		
		logGenericAccount = (Button) view.findViewById(R.id.setup_login_generic);
		if (getResources().getBoolean(R.bool.hide_generic_accounts_wizard)) {
			view.findViewById(R.id.setup_login_generic_layout).setVisibility(View.GONE);
		} else {
			logGenericAccount.setOnClickListener(this);
		}
		
		remoteProvisioning = (Button) view.findViewById(R.id.setup_remote_provisioning);
		if (getResources().getBoolean(R.bool.hide_remote_provisioning_in_wizard)) {
			view.findViewById(R.id.setup_remote_provisioning_layout).setVisibility(View.GONE);
		} else {
			remoteProvisioning.setOnClickListener(this);
		}
		
		return view;
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		if (id == R.id.setup_login_generic) {
			AssistantActivity.instance().displayLoginGeneric();
		} else if (id == R.id.setup_login_linphone) {
			AssistantActivity.instance().displayLoginLinphone();
		} else if (id == R.id.setup_create_account) {
			AssistantActivity.instance().displayWizard();
		} else if (id == R.id.setup_remote_provisioning) {
			AssistantActivity.instance().displayRemoteProvisioning();
		}
	}
}
