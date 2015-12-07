Vagrant.require_version ">= 1.7.0"
project = "vagrant-aprendiz"
cache = ".vagrant/machines/default/cache"

Vagrant.configure(2) do |config|
  config.vm.box = "debian/jessie64"
  config.vm.box_check_update = false
  config.vm.hostname = project
  config.vm.network "forwarded_port", guest: 1521, host: 1521

  config.vm.provider "virtualbox" do |vbox|
    vbox.name = project
    vbox.cpus = 1
    vbox.memory = 512
    vbox.customize ["modifyvm", :id, "--cpuexecutioncap", "50"]
  end

  config.vm.synced_folder "#{cache}/apt", "/var/cache/apt/archives", create: true , owner: "root", group: "root"
  config.vm.synced_folder "#{cache}/docker", "/var/cache/docker", create: true , owner: "root", group: "root"
  config.vm.provision "shell", run: "always", path: ".provision/setup.sh"
end
