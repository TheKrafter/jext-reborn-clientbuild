<script lang="ts">
	import {
		github,
		spigotmc,
		modrinth,
		hangar,
		warning,
		workflow,
		wrench,
		hand_helping,
		connectionless
	} from '$lib/assets';

	import { Step, Stepper, Accordion, AccordionItem } from '@skeletonlabs/skeleton';

	import { base } from '$app/paths';
</script>

<div class="mb-10" />
<Stepper
	on:complete={() => {
		alert('You have completed the quickstart guide!');
		window.location.href = window.location.href.split('/').slice(0, -2).join('/');
	}}
>
	<Step>
		<svelte:fragment slot="header">Downloading and installing the plugin</svelte:fragment>
		<p>You can download the plugin from any of these sources:</p>
		<div class="logo-cloud grid-cols-1 sm:grid-cols-2 lg:!grid-cols-4 gap-1">
			<a
				class="logo-item"
				href="https://www.spigotmc.org/resources/jukebox-extended-reborn-add-custom-music-discs.103219/"
				target="_blank"
			>
				<span class="h-full"><img src={spigotmc} alt="github" srcset="" class="h-full" /></span>
				<span>Spigot MC</span>
			</a>
			<a
				class="logo-item border-cyan-500 border-4"
				href="https://modrinth.com/plugin/jukebox-extended-reborn"
				target="_blank"
			>
				<span class="h-full"><img src={modrinth} alt="github" srcset="" class="h-full" /></span>
				<span>Modrinth</span>
			</a>
			<a
				class="logo-item"
				href="https://hangar.papermc.io/spartacus04/JukeboxExtendedReborn"
				target="_blank"
			>
				<span class="h-full"><img src={hangar} alt="github" srcset="" class="h-full" /></span>
				<span>Hangar</span>
			</a>
			<a
				class="logo-item"
				href="https://github.com/spartacus04/jext-reborn/releases/latest"
				target="_blank"
			>
				<span class="h-full"><img src={github} alt="github" srcset="" class="h-full" /></span>
				<span>Github</span>
			</a>
		</div>

		<div class="bg-cyan-500 rounded-lg">
			<Accordion>
				<AccordionItem>
					<svelte:fragment slot="lead">
						<img src={hand_helping} alt="warning" />
					</svelte:fragment>
					<svelte:fragment slot="summary"
						>Sources highlighted in this color help the developer!</svelte:fragment
					>
					<svelte:fragment slot="content">
						<p>
							Did you know that Modrinth runs a monetization program? That means that for each free
							download from modrinth the developer gets paid a few cents!
						</p>
						<p>
							That's not a lot, but it can help me improve the plugin faster and be a bit more
							motivated.
						</p>
					</svelte:fragment>
				</AccordionItem>
			</Accordion>
		</div>

		You also need to download Protocollib as it's one of the<b class="underline">required</b>
		dependencies, you can download it from any of these sources:

		<div class="logo-cloud grid-cols-1 sm:grid-cols-3 gap-1">
			<a
				class="logo-item"
				href="https://www.spigotmc.org/resources/protocollib.1997/"
				target="_blank"
			>
				<span class="h-full"><img src={spigotmc} alt="github" srcset="" class="h-full" /></span>
				<span>Spigot MC</span>
			</a>
			<a class="logo-item" href="https://hangar.papermc.io/dmulloy2/ProtocolLib" target="_blank">
				<span class="h-full"><img src={hangar} alt="github" srcset="" class="h-full" /></span>
				<span>Hangar</span>
			</a>
			<a
				class="logo-item"
				href="https://github.com/dmulloy2/ProtocolLib/releases/latest"
				target="_blank"
			>
				<span class="h-full"><img src={github} alt="github" srcset="" class="h-full" /></span>
				<span>Github</span>
			</a>
		</div>

		<div class="bg-orange-900 rounded-lg">
			<Accordion>
				<AccordionItem>
					<svelte:fragment slot="lead">
						<img src={warning} alt="warning" />
					</svelte:fragment>
					<svelte:fragment slot="summary"
						>Protocollib does not support my minecraft version yet, what should I do?</svelte:fragment
					>
					<svelte:fragment slot="content">
						<p>
							Sometimes protocollib gets updated for later versions but the actual update doesn't
							get published until later dates. You can download these updated versions from the
							latest successful compilation on their Jenkins CI (<a
								href="https://ci.dmulloy2.net/job/ProtocolLib/"
								target="_blank">here!</a
							>).
						</p>
						<b>Be warned though, these versions may be unstable or sometimes not even work.</b>
					</svelte:fragment>
				</AccordionItem>
			</Accordion>
		</div>

		<p>Once you have the plugin, drop it in your plugins folder and restart the server.</p>

		<p>You should see this message in the server output:</p>

		<blockquote class="bg-black p-2 flex font-cascadia">
			[
			<p class="text-mc-light-green">JEXT</p>
			] &#160
			<p class="text-mc-light-green">Enabled Jukebox Extended Reborn, Do Re Mi!</p>
		</blockquote>

		<p>
			The plugin should work on every Spigot-flavoured server (Spigot, Paper, Purpur, Folia & more).
			You are now ready to configure it!
		</p>
	</Step>
	<Step>
		<svelte:fragment slot="header">Configuring the plugin</svelte:fragment>
		<Accordion autocollapse>
			<AccordionItem open>
				<svelte:fragment slot="lead">
					<img src={workflow} alt="warning" />
				</svelte:fragment>
				<svelte:fragment slot="summary">Configuring using the Web UI</svelte:fragment>
				<svelte:fragment slot="content">
					<p>In your server console, or as an administrator in-game, run the following command</p>

					<blockquote class="bg-black p-2 flex font-cascadia">/jext webui config</blockquote>

					<p>The server should output a hyperlink like this one</p>

					<blockquote class="bg-black p-2 flex font-cascadia">
						[
						<p class="text-mc-light-green">JEXT</p>
						] &#160
						<p class="text-mc-light-green">
							Web UI available at
							https://spartacus04.github.io/jext-reborn/config?c=c&ip=127.0.0.1&port=9871
						</p>
					</blockquote>

					<p>
						Click on it and you should be greeted with the web UI, if you previously configured a
						web UI password, you will be prompted to enter it.
					</p>
					<p>
						Occasionally the web UI could also require the ip address of the server and port of the
						jext web interface api.
					</p>
					<p>
						You can now configure the plugin from the webUI, and apply your setting by clicking the
						apply button.
					</p>

					<div class="bg-orange-900 rounded-lg">
						<Accordion>
							<AccordionItem>
								<svelte:fragment slot="lead">
									<img src={warning} alt="warning" />
								</svelte:fragment>
								<svelte:fragment slot="summary"
									>Can't connect to the jext server, what should I do?</svelte:fragment
								>
								<svelte:fragment slot="content">
									<p>
										Try clicking on the connect button and input the parameters manually, if it's
										still not working you can configure the plugin manually, it's not difficult!
									</p>
								</svelte:fragment>
							</AccordionItem>
						</Accordion>
					</div>
				</svelte:fragment>
			</AccordionItem>
			<AccordionItem>
				<svelte:fragment slot="lead">
					<img src={wrench} alt="warning" />
				</svelte:fragment>
				<svelte:fragment slot="summary">Configuring manually</svelte:fragment>
				<svelte:fragment slot="content">
					The plugin comes with a default configuration file that you can use as a base, you can
					find it in the <code>plugins/JukeboxExtendedReborn</code> folder. You can edit it with any
					text editor, and you can check out the
					<a href="{base}/documentation/config">config documentation</a> for more information on how
					to configure the plugin.
				</svelte:fragment>
			</AccordionItem>
		</Accordion>
	</Step>
	<Step>
		<svelte:fragment slot="header">Adding your first custom disc</svelte:fragment>
		<Accordion autocollapse>
			<AccordionItem open>
				<svelte:fragment slot="lead">
					<img src={workflow} alt="warning" />
				</svelte:fragment>
				<svelte:fragment slot="summary">Adding custom discs using the Web UI</svelte:fragment>
				<svelte:fragment slot="content">
					<p>In your server console, or as an administrator in-game, run the following command</p>

					<blockquote class="bg-black p-2 flex font-cascadia">/jext webui discs</blockquote>

					<p>The server should output a hyperlink like this one</p>

					<blockquote class="bg-black p-2 flex font-cascadia">
						[
						<p class="text-mc-light-green">JEXT</p>
						] &#160
						<p class="text-mc-light-green">
							Web UI available at
							https://spartacus04.github.io/jext-reborn?c=c&ip=127.0.0.1&port=9871
						</p>
					</blockquote>

					<p>
						Click on it and you should be greeted with the web UI, if you previously configured a
						web UI password, you will be prompted to enter it.
					</p>
					<p>
						Occasionally the web UI could also require the ip address of the server and port of the
						jext web interface api.
					</p>
					<p>
						You can now edit the custom discs for a comfortable ui designed to make the process as
						easy as possible!
					</p>

					<div class="bg-orange-900 rounded-lg">
						<Accordion>
							<AccordionItem>
								<svelte:fragment slot="lead">
									<img src={warning} alt="warning" />
								</svelte:fragment>
								<svelte:fragment slot="summary"
									>Can't connect to the jext server, what should I do?</svelte:fragment
								>
								<svelte:fragment slot="content">
									<p>
										Try clicking on the connect button and input the parameters manually.<br /><br
										/>If it's still not working, you can follow the
										<code>Adding custom discs using the Web UI (connectionless)</code> guide
									</p>
								</svelte:fragment>
							</AccordionItem>
						</Accordion>
					</div>
				</svelte:fragment>
			</AccordionItem>
			<AccordionItem>
				<svelte:fragment slot="lead">
					<img src={connectionless} alt="warning" />
				</svelte:fragment>
				<svelte:fragment slot="summary"
					>Adding custom discs using the Web UI (connectionless)</svelte:fragment
				>
				<svelte:fragment slot="content">
					<p>
						If you don't want to connect to the webUI, or you can't due to a esoteric server setup,
						you can use the webui to generate the discs automatically
					</p>
					<p>
						Just navigate to the <a
							href="http://spartacus04.github.io/jext-reborn/"
							target="_blank"
							rel="noopener noreferrer">discs</a
						> page and start adding them without connecting to the server.
					</p>

					<p>
						You can now edit the custom discs for a comfortable ui designed to make the process as
						easy as possible!
					</p>

					<hr />

					<p>
						After finishing generating the discs you can apply the resourcepack by either hosting it
						manually or using a the built-in resource pack host.
					</p>

					<div class="bg-purple-900 rounded-lg">
						<Accordion>
							<AccordionItem>
								<svelte:fragment slot="lead">
									<img src={workflow} alt="warning" />
								</svelte:fragment>
								<svelte:fragment slot="summary"
									>Using the built-in resource pack host</svelte:fragment
								>
								<svelte:fragment slot="content">
									<p>
										After generating the resource pack, click on the "Download Resource Pack for
										Minecraft: Java Edition" button, and place the downloaded resourcepack in the
										`JukeboxExtendedReborn/resource-pack.zip`.
									</p>
								</svelte:fragment>
							</AccordionItem>
						</Accordion>
					</div>

					<div class="bg-purple-900 rounded-lg">
						<Accordion>
							<AccordionItem>
								<svelte:fragment slot="lead">
									<img src={connectionless} alt="warning" />
								</svelte:fragment>
								<svelte:fragment slot="summary">Hosting the resourcepack yourself</svelte:fragment>
								<svelte:fragment slot="content">
									<p>
										If the resource-pack host isn't working (common for esoteric server
										environments) you can host the resourcepack manually.
									</p>
									<p>
										After generating the resource pack, click on the "Download Resource Pack for
										Minecraft: Java Edition" button, host the resourcepack like you would manually
										and remember to <b
											>set the <code>resource-pack-sha1</code> property in the
											<code>server.properties</code> file</b
										>.
									</p>
								</svelte:fragment>
							</AccordionItem>
						</Accordion>
					</div>

					<div class="bg-purple-900 rounded-lg">
						<Accordion>
							<AccordionItem>
								<svelte:fragment slot="lead">
									<img src={wrench} alt="warning" />
								</svelte:fragment>
								<svelte:fragment slot="summary"
									>Hosting the resourcepack yourself and using the manual disc loading method</svelte:fragment
								>
								<svelte:fragment slot="content">
									<p>If both options aren't working you can try loading the disc data manually.</p>
									<p>
										After generating the resource pack, click on the "Download Resource Pack for
										Minecraft: Java Edition" button, host the resourcepack like you would manually.
										In the Web UI click the small square download button near the "Download Resource
										Pack" button, and place the downloaded file into the <code
											>JukeboxExtendedReborn/discs.json</code
										> path.
									</p>
								</svelte:fragment>
							</AccordionItem>
						</Accordion>
					</div>
				</svelte:fragment>
			</AccordionItem>
			<AccordionItem>
				<svelte:fragment slot="lead">
					<img src={wrench} alt="warning" />
				</svelte:fragment>
				<svelte:fragment slot="summary">Configuring manually</svelte:fragment>
				<svelte:fragment slot="content">
					Altought it's not recommended you can also add custom discs manually by using a jext.json
					file inside a resource pack, you can check out the <a
						href="{base}/documentation/resourcepack">resourcepack documentation</a
					> for more information on how to manage discs.
				</svelte:fragment>
			</AccordionItem>
		</Accordion>
	</Step>
</Stepper>
