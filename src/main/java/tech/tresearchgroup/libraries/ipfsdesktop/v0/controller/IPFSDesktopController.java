package tech.tresearchgroup.libraries.ipfsdesktop.v0.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tech.tresearchgroup.libraries.ipfsdesktop.v0.model.IPFSDesktop;

import java.io.File;

public class IPFSDesktopController implements IPFSDesktopAPI {
    Gson gson = new GsonBuilder().setLenient().create();
    Retrofit retrofit = new Retrofit.Builder().baseUrl("http://localhost:5001/").addConverterFactory(GsonConverterFactory.create(gson)).build();
    IPFSDesktopAPI ipfsDesktopAPI = retrofit.create(IPFSDesktopAPI.class);

    public Call<IPFSDesktop> add(File file,
                                 boolean quiet,
                                 boolean quieter,
                                 boolean silent,
                                 boolean progress,
                                 boolean trickle,
                                 boolean onlyHash,
                                 boolean wrapWithDirectory,
                                 String chunker,
                                 boolean pin,
                                 boolean rawLeaves,
                                 boolean noCopy,
                                 boolean fsCache,
                                 int cidVersion,
                                 String hash,
                                 boolean inline,
                                 int inlineLimit) {
        return ipfsDesktopAPI.add(file, quiet, quieter, silent, progress, trickle, onlyHash, wrapWithDirectory, chunker, pin, rawLeaves, noCopy, fsCache, cidVersion, hash, inline, inlineLimit);
    }

    public Call<IPFSDesktop> bitswap(String arg) {
        return ipfsDesktopAPI.bitswap(arg);
    }

    public Call<IPFSDesktop> bitswapReprovide() {
        return ipfsDesktopAPI.bitswapReprovide();
    }

    public Call<IPFSDesktop> bitswapStat(boolean verbose,
                                         boolean human) {
        return ipfsDesktopAPI.bitswapStat(verbose, human);
    }

    public Call<IPFSDesktop> bitswapWantList(String peer) {
        return ipfsDesktopAPI.bitswapWantList(peer);
    }

    public Call<IPFSDesktop> blockGet(String arg) {
        return ipfsDesktopAPI.blockGet(arg);
    }

    public Call<IPFSDesktop> blockPut(File file,
                                      String format,
                                      String mhType,
                                      int mhLen,
                                      boolean pin) {
        return ipfsDesktopAPI.blockPut(file, format, mhType, mhLen, pin);
    }

    public Call<IPFSDesktop> blockRm(String arg,
                                     boolean force,
                                     boolean quiet) {
        return ipfsDesktopAPI.blockRm(arg, force, quiet);
    }

    public Call<IPFSDesktop> blockStat(String arg) {
        return ipfsDesktopAPI.blockStat(arg);
    }

    public Call<IPFSDesktop> bootstrap() {
        return ipfsDesktopAPI.bootstrap();
    }

    public Call<IPFSDesktop> bootstrapAdd(String arg,
                                          boolean isDefault) {
        return ipfsDesktopAPI.bootstrapAdd(arg, isDefault);
    }

    public Call<IPFSDesktop> bootstrapAddDefault() {
        return ipfsDesktopAPI.bootstrapAddDefault();
    }

    public Call<IPFSDesktop> bootstrapList() {
        return ipfsDesktopAPI.bootstrapList();
    }

    public Call<IPFSDesktop> bootstrapRm(String arg,
                                         boolean all) {
        return ipfsDesktopAPI.bootstrapRm(arg, all);
    }

    public Call<IPFSDesktop> bootstrapRmAll() {
        return ipfsDesktopAPI.bootstrapRmAll();
    }

    public Call<IPFSDesktop> cat(String arg,
                                 int offset,
                                 int length) {
        return ipfsDesktopAPI.cat(arg, offset, length);
    }

    public Call<IPFSDesktop> cidBase32(String arg) {
        return ipfsDesktopAPI.cidBase32(arg);
    }

    public Call<IPFSDesktop> cidBases(boolean prefix,
                                      boolean numeric) {
        return ipfsDesktopAPI.cidBases(prefix, numeric);
    }

    public Call<IPFSDesktop> cidCodecs(boolean numeric) {
        return ipfsDesktopAPI.cidCodecs(numeric);
    }

    public Call<IPFSDesktop> cidFormat(String arg,
                                       String f,
                                       String v,
                                       String codec,
                                       String b) {
        return ipfsDesktopAPI.cidFormat(arg, f, v, codec, b);
    }

    public Call<IPFSDesktop> cidHashes(boolean numeric) {
        return ipfsDesktopAPI.cidHashes(numeric);
    }

    public Call<IPFSDesktop> commands(boolean flags) {
        return ipfsDesktopAPI.commands(flags);
    }

    public Call<IPFSDesktop> commandsCompletionBash() {
        return ipfsDesktopAPI.commandsCompletionBash();
    }

    public Call<IPFSDesktop> config(String firstArg,
                                    String secondArg,
                                    boolean bool,
                                    boolean json) {
        return ipfsDesktopAPI.config(firstArg, secondArg, bool, json);
    }

    public Call<IPFSDesktop> configEdit() {
        return ipfsDesktopAPI.configEdit();
    }

    public Call<IPFSDesktop> configProfileApply(String arg,
                                                boolean dryRun) {
        return ipfsDesktopAPI.configProfileApply(arg, dryRun);
    }

    public Call<IPFSDesktop> configReplace(File file) {
        return ipfsDesktopAPI.configReplace(file);
    }

    public Call<IPFSDesktop> configShow() {
        return ipfsDesktopAPI.configShow();
    }

    public Call<IPFSDesktop> dagExport(String arg,
                                       boolean progress) {
        return ipfsDesktopAPI.dagExport(arg, progress);
    }

    public Call<IPFSDesktop> dagGet(String arg,
                                    String outputCodec) {
        return ipfsDesktopAPI.dagGet(arg, outputCodec);
    }

    public Call<IPFSDesktop> dagImport(boolean pinRoots,
                                       boolean silent,
                                       boolean stats) {
        return ipfsDesktopAPI.dagImport(pinRoots, silent, stats);
    }

    public Call<IPFSDesktop> dagPut(String storeCodec,
                                    String inputCodec,
                                    boolean pin,
                                    String hash) {
        return ipfsDesktopAPI.dagPut(storeCodec, inputCodec, pin, hash);
    }

    public Call<IPFSDesktop> dagResolve(String arg) {
        return ipfsDesktopAPI.dagResolve(arg);
    }

    public Call<IPFSDesktop> dagStat(String arg,
                                     boolean progress) {
        return ipfsDesktopAPI.dagStat(arg, progress);
    }

    public Call<IPFSDesktop> dhtFindPeer(String arg,
                                         boolean verbose) {
        return ipfsDesktopAPI.dhtFindPeer(arg, verbose);
    }

    public Call<IPFSDesktop> dhtFindProvs(String arg,
                                          boolean verbose,
                                          int numProviders) {
        return ipfsDesktopAPI.dhtFindProvs(arg, verbose, numProviders);
    }

    public Call<IPFSDesktop> dhtGet(String arg,
                                    boolean verbose) {
        return ipfsDesktopAPI.dhtGet(arg, verbose);
    }

    public Call<IPFSDesktop> dhtProvide(String arg,
                                        boolean verbose,
                                        boolean recursive) {
        return ipfsDesktopAPI.dhtProvide(arg, verbose, recursive);
    }

    public Call<IPFSDesktop> dhtPut(String arg,
                                    boolean verbose) {
        return ipfsDesktopAPI.dhtPut(arg, verbose);
    }

    public Call<IPFSDesktop> dhtQuery(String arg,
                                      boolean verbose) {
        return ipfsDesktopAPI.dhtQuery(arg, verbose);
    }

    public Call<IPFSDesktop> diagCmds(boolean verbose) {
        return ipfsDesktopAPI.diagCmds(verbose);
    }

    public Call<IPFSDesktop> diagCmdsClear() {
        return ipfsDesktopAPI.diagCmdsClear();
    }

    public Call<IPFSDesktop> diagCmdsSetTime(String arg) {
        return ipfsDesktopAPI.diagCmdsSetTime(arg);
    }

    public Call<IPFSDesktop> diagProfile(String output,
                                         String cpuProfileTime) {
        return ipfsDesktopAPI.diagProfile(output, cpuProfileTime);
    }

    public Call<IPFSDesktop> diagSys() {
        return ipfsDesktopAPI.diagSys();
    }

    public Call<IPFSDesktop> dns(String arg,
                                 boolean recursive) {
        return ipfsDesktopAPI.dns(arg, recursive);
    }

    public Call<IPFSDesktop> fileLs(String arg) {
        return ipfsDesktopAPI.fileLs(arg);
    }

    public Call<IPFSDesktop> filesChcid(String arg,
                                        int cidVersion,
                                        String hash) {
        return ipfsDesktopAPI.filesChcid(arg, cidVersion, hash);
    }

    public Call<IPFSDesktop> filesCp(String firstArg,
                                     String secondArg,
                                     boolean parents) {
        return ipfsDesktopAPI.filesCp(firstArg, secondArg, parents);
    }

    public Call<IPFSDesktop> filesFlush(String arg) {
        return ipfsDesktopAPI.filesFlush(arg);
    }

    public Call<IPFSDesktop> filesLs(String arg,
                                     boolean longList,
                                     boolean u) {
        return ipfsDesktopAPI.filesLs(arg, longList, u);
    }

    public Call<IPFSDesktop> filesMkdir(String arg,
                                        boolean parents,
                                        int cidVersion,
                                        String hash) {
        return ipfsDesktopAPI.filesMkdir(arg, parents, cidVersion, hash);
    }

    public Call<IPFSDesktop> filesMv(String firstArg,
                                     String secondArg) {
        return ipfsDesktopAPI.filesMv(firstArg, secondArg);
    }

    public Call<IPFSDesktop> filesRead(String arg,
                                       int offset,
                                       int count) {
        return filesRead(arg, offset, count);
    }

    public Call<IPFSDesktop> filesRm(String arg,
                                     boolean recursive,
                                     boolean force) {
        return filesRm(arg, recursive, force);
    }

    public Call<IPFSDesktop> filesStat(String arg,
                                       String format,
                                       boolean hash,
                                       boolean size,
                                       boolean withLocal) {
        return ipfsDesktopAPI.filesStat(arg, format, hash, size, withLocal);
    }

    public Call<IPFSDesktop> filesWrite(String arg,
                                        int offset,
                                        boolean create,
                                        boolean parents,
                                        boolean truncate,
                                        int count,
                                        boolean rawLeaves,
                                        int cidVersion,
                                        String hash) {
        return ipfsDesktopAPI.filesWrite(arg, offset, create, parents, truncate, count, rawLeaves, cidVersion, hash);
    }

    public Call<IPFSDesktop> filestoreDups() {
        return ipfsDesktopAPI.filestoreDups();
    }

    public Call<IPFSDesktop> filestoreLs(String arg,
                                         boolean fileOrder) {
        return ipfsDesktopAPI.filestoreLs(arg, fileOrder);
    }

    public Call<IPFSDesktop> filestoreVerify(String arg,
                                             boolean fileOrder) {
        return filestoreVerify(arg, fileOrder);
    }

    public Call<IPFSDesktop> get(String arg,
                                 String output,
                                 boolean archive,
                                 boolean compress,
                                 int compressionLevel) {
        return ipfsDesktopAPI.get(arg, output, archive, compress, compressionLevel);
    }

    public Call<IPFSDesktop> id(String arg,
                                String format,
                                String peeridBase) {
        return ipfsDesktopAPI.id(arg, format, peeridBase);
    }

    public Call<IPFSDesktop> keyExport(String arg,
                                       String output) {
        return ipfsDesktopAPI.keyExport(arg, output);
    }

    public Call<IPFSDesktop> keyGen(String arg,
                                    String type,
                                    int size,
                                    String ipnsBase) {
        return ipfsDesktopAPI.keyGen(arg, type, size, ipnsBase);
    }

    public Call<IPFSDesktop> keyImport(String arg,
                                       String ipnsBase) {
        return ipfsDesktopAPI.keyImport(arg, ipnsBase);
    }

    public Call<IPFSDesktop> keyList(boolean l,
                                     String ipnsBase) {
        return ipfsDesktopAPI.keyList(l, ipnsBase);
    }

    public Call<IPFSDesktop> keyRename(String firstArg,
                                       String secondArg,
                                       boolean force,
                                       String ipnsBase) {
        return ipfsDesktopAPI.keyRename(firstArg, secondArg, force, ipnsBase);
    }

    public Call<IPFSDesktop> keyRm(String arg,
                                   boolean l,
                                   String ipnsBase) {
        return ipfsDesktopAPI.keyRm(arg, l, ipnsBase);
    }

    public Call<IPFSDesktop> keyRotate(String oldKey,
                                       String type,
                                       int size) {
        return ipfsDesktopAPI.keyRotate(oldKey, type, size);
    }

    public Call<IPFSDesktop> logLevel(String firstArg,
                                      String secondArg) {
        return ipfsDesktopAPI.logLevel(firstArg, secondArg);
    }

    public Call<IPFSDesktop> logLs() {
        return ipfsDesktopAPI.logLs();
    }

    public Call<IPFSDesktop> logTail() {
        return ipfsDesktopAPI.logTail();
    }

    public Call<IPFSDesktop> ls(String arg,
                                boolean headers,
                                boolean resolveType,
                                boolean size,
                                boolean stream) {
        return ipfsDesktopAPI.ls(arg, headers, resolveType, size, stream);
    }

    public Call<IPFSDesktop> mount(String ipfsPath,
                                   String ipnsPath) {
        return ipfsDesktopAPI.mount(ipfsPath, ipnsPath);
    }

    public Call<IPFSDesktop> multibaseDecode(File file) {
        return ipfsDesktopAPI.multibaseDecode(file);
    }

    public Call<IPFSDesktop> multibaseEncode(String b) {
        return ipfsDesktopAPI.multibaseEncode(b);
    }

    public Call<IPFSDesktop> multibaseList(boolean prefix,
                                           boolean numeric) {
        return ipfsDesktopAPI.multibaseList(prefix, numeric);
    }

    public Call<IPFSDesktop> multibaseTranscode(String b) {
        return ipfsDesktopAPI.multibaseTranscode(b);
    }

    public Call<IPFSDesktop> namePublish(String arg,
                                         boolean resolve,
                                         String lifetime,
                                         boolean allowOffline,
                                         String ttl,
                                         String key,
                                         boolean quieter,
                                         String ipnsBase) {
        return ipfsDesktopAPI.namePublish(arg, resolve, lifetime, allowOffline, ttl, key, quieter, ipnsBase);
    }

    public Call<IPFSDesktop> namePubsubCancel(String arg) {
        return ipfsDesktopAPI.namePubsubCancel(arg);
    }

    public Call<IPFSDesktop> namePubsubState() {
        return ipfsDesktopAPI.namePubsubState();
    }

    public Call<IPFSDesktop> namePubsubSubs(String ipnsBase) {
        return ipfsDesktopAPI.namePubsubSubs(ipnsBase);
    }

    public Call<IPFSDesktop> nameResolve(String arg,
                                         boolean recursive,
                                         boolean nocache,
                                         int dhtRecordCount,
                                         String dhtTimeout,
                                         boolean stream) {
        return ipfsDesktopAPI.nameResolve(arg, recursive, nocache, dhtRecordCount, dhtTimeout, stream);
    }

    public Call<IPFSDesktop> objectData(String arg) {
        return ipfsDesktopAPI.objectData(arg);
    }

    public Call<IPFSDesktop> objectDiff(String firstArg,
                                        String secondArg,
                                        boolean verbose) {
        return ipfsDesktopAPI.objectDiff(firstArg, secondArg, verbose);
    }

    public Call<IPFSDesktop> objectGet(String arg,
                                       String dataEncoding) {
        return ipfsDesktopAPI.objectGet(arg, dataEncoding);
    }

    public Call<IPFSDesktop> objectLinks(String arg,
                                         boolean headers) {
        return ipfsDesktopAPI.objectLinks(arg, headers);
    }

    public Call<IPFSDesktop> objectNew(String arg) {
        return ipfsDesktopAPI.objectNew(arg);
    }

    public Call<IPFSDesktop> objectPatchAddLink(String firstArg,
                                                String secondArg,
                                                String thirdArg,
                                                boolean create) {
        return ipfsDesktopAPI.objectPatchAddLink(firstArg, secondArg, thirdArg, create);
    }

    public Call<IPFSDesktop> objectPatchAppendData(String arg) {
        return ipfsDesktopAPI.objectPatchAppendData(arg);
    }

    public Call<IPFSDesktop> objectPatchRmLink(String firstArg,
                                               String secondArg) {
        return ipfsDesktopAPI.objectPatchRmLink(firstArg, secondArg);
    }

    public Call<IPFSDesktop> objectPatchSetData(String arg) {
        return ipfsDesktopAPI.objectPatchSetData(arg);
    }

    public Call<IPFSDesktop> objectPut(String inputenc,
                                       String datafieldenc,
                                       boolean pin,
                                       boolean quiet) {
        return ipfsDesktopAPI.objectPut(inputenc, datafieldenc, pin, quiet);
    }

    public Call<IPFSDesktop> objectStat(String arg,
                                        boolean human) {
        return ipfsDesktopAPI.objectStat(arg, human);
    }

    public Call<IPFSDesktop> p2pClose(boolean all,
                                      String protocol,
                                      String listenAddress,
                                      String targetAddress) {
        return ipfsDesktopAPI.p2pClose(all, protocol, listenAddress, targetAddress);
    }

    public Call<IPFSDesktop> p2pForward(String firstArg,
                                        String secondArg,
                                        String thirdArg,
                                        boolean allowCustomProtocol) {
        return ipfsDesktopAPI.p2pForward(firstArg, secondArg, thirdArg, allowCustomProtocol);
    }

    public Call<IPFSDesktop> p2pListen(String firstArg,
                                       String secondArg,
                                       boolean allowCustomProtocol,
                                       boolean reportPeerId) {
        return ipfsDesktopAPI.p2pListen(firstArg, secondArg, allowCustomProtocol, reportPeerId);
    }

    public Call<IPFSDesktop> p2pLs(boolean headers) {
        return ipfsDesktopAPI.p2pLs(headers);
    }

    public Call<IPFSDesktop> p2pStreamClose(String arg,
                                            boolean all) {
        return ipfsDesktopAPI.p2pStreamClose(arg, all);
    }

    public Call<IPFSDesktop> p2pStreamLs(boolean headers) {
        return ipfsDesktopAPI.p2pStreamLs(headers);
    }

    public Call<IPFSDesktop> pinAdd(String arg,
                                    boolean recursive,
                                    boolean progress) {
        return ipfsDesktopAPI.pinAdd(arg, recursive, progress);
    }

    public Call<IPFSDesktop> pinLs(String arg,
                                   String type,
                                   boolean quiet,
                                   boolean stream) {
        return ipfsDesktopAPI.pinLs(arg, type, quiet, stream);
    }

    public Call<IPFSDesktop> pinRemoteAdd(String arg,
                                          String service,
                                          String name,
                                          boolean background) {
        return ipfsDesktopAPI.pinRemoteAdd(arg, service, name, background);
    }

    public Call<IPFSDesktop> pinRemoteLs(String service,
                                         String name,
                                         String cid,
                                         String status) {
        return ipfsDesktopAPI.pinRemoteLs(service, name, cid, status);
    }

    public Call<IPFSDesktop> pinRemoteRm(String service,
                                         String name,
                                         String cid,
                                         String status,
                                         boolean force) {
        return ipfsDesktopAPI.pinRemoteRm(service, name, cid, status, force);
    }

    public Call<IPFSDesktop> pinRemoteServiceAdd(String firstArg,
                                                 String secondArg,
                                                 String thirdArg) {
        return ipfsDesktopAPI.pinRemoteServiceAdd(firstArg, secondArg, thirdArg);
    }

    public Call<IPFSDesktop> pinRemoteServiceLs(boolean stat) {
        return ipfsDesktopAPI.pinRemoteServiceLs(stat);
    }

    public Call<IPFSDesktop> pinRemoteServiceRm(String arg) {
        return ipfsDesktopAPI.pinRemoteServiceRm(arg);
    }

    public Call<IPFSDesktop> pinRm(String arg,
                                   boolean recursive) {
        return ipfsDesktopAPI.pinRm(arg, recursive);
    }

    public Call<IPFSDesktop> pinUpdate(String firstArg,
                                       String secondArg,
                                       boolean unpin) {
        return ipfsDesktopAPI.pinUpdate(firstArg, secondArg, unpin);
    }

    public Call<IPFSDesktop> pinVerify(boolean verbose,
                                       boolean quiet) {
        return ipfsDesktopAPI.pinVerify(verbose, quiet);
    }

    public Call<IPFSDesktop> ping(String arg,
                                  int count) {
        return ipfsDesktopAPI.ping(arg, count);
    }

    public Call<IPFSDesktop> pubsubLs() {
        return ipfsDesktopAPI.pubsubLs();
    }

    public Call<IPFSDesktop> pubsubPeers(String arg) {
        return ipfsDesktopAPI.pubsubPeers(arg);
    }

    public Call<IPFSDesktop> pubsubPub(String arg) {
        return ipfsDesktopAPI.pubsubPub(arg);
    }

    public Call<IPFSDesktop> pubsubSub(String arg) {
        return ipfsDesktopAPI.pubsubSub(arg);
    }

    public Call<IPFSDesktop> refs(String arg,
                                  String format,
                                  boolean edges,
                                  boolean unique,
                                  boolean recursive,
                                  int maxDepth) {
        return ipfsDesktopAPI.refs(arg, format, edges, unique, recursive, maxDepth);
    }

    public Call<IPFSDesktop> refsLocal() {
        return ipfsDesktopAPI.refsLocal();
    }

    public Call<IPFSDesktop> repoFsck() {
        return ipfsDesktopAPI.repoFsck();
    }

    public Call<IPFSDesktop> repoGc(boolean streamErrors,
                                    boolean quiet) {
        return ipfsDesktopAPI.repoGc(streamErrors, quiet);
    }

    public Call<IPFSDesktop> repoStat(boolean sizeOnly,
                                      boolean human) {
        return ipfsDesktopAPI.repoStat(sizeOnly, human);
    }

    public Call<IPFSDesktop> repoVerify() {
        return ipfsDesktopAPI.repoVerify();
    }

    public Call<IPFSDesktop> repoVersion(boolean quiet) {
        return ipfsDesktopAPI.repoVersion(quiet);
    }

    public Call<IPFSDesktop> resolve(String arg,
                                     boolean recursive,
                                     int dhtRecordCount,
                                     String dhtTimeout) {
        return ipfsDesktopAPI.resolve(arg, recursive, dhtRecordCount, dhtTimeout);
    }

    public Call<IPFSDesktop> shutdown() {
        return ipfsDesktopAPI.shutdown();
    }

    public Call<IPFSDesktop> statsBitswap(boolean verbose,
                                          boolean human) {
        return ipfsDesktopAPI.statsBitswap(verbose, human);
    }

    public Call<IPFSDesktop> statsBw(String peer,
                                     String proto,
                                     boolean poll,
                                     String interval) {
        return ipfsDesktopAPI.statsBw(peer, proto, poll, interval);
    }

    public Call<IPFSDesktop> statsDht(String arg) {
        return ipfsDesktopAPI.statsDht(arg);
    }

    public Call<IPFSDesktop> statsProvide() {
        return ipfsDesktopAPI.statsProvide();
    }

    public Call<IPFSDesktop> statsRepo(boolean sizeOnly,
                                       boolean human) {
        return ipfsDesktopAPI.statsRepo(sizeOnly, human);
    }

    public Call<IPFSDesktop> swarmAddrs() {
        return ipfsDesktopAPI.swarmAddrs();
    }

    public Call<IPFSDesktop> swarmAddrsListen() {
        return ipfsDesktopAPI.swarmAddrsListen();
    }

    public Call<IPFSDesktop> swarmAddrsLocal(boolean id) {
        return ipfsDesktopAPI.swarmAddrsLocal(id);
    }

    public Call<IPFSDesktop> swarmConnect(String arg) {
        return ipfsDesktopAPI.swarmConnect(arg);
    }

    public Call<IPFSDesktop> swarmDisconnect(String arg) {
        return ipfsDesktopAPI.swarmDisconnect(arg);
    }

    public Call<IPFSDesktop> swarmFilters() {
        return ipfsDesktopAPI.swarmFilters();
    }

    public Call<IPFSDesktop> swarmFiltersAdd(String arg) {
        return ipfsDesktopAPI.swarmFiltersAdd(arg);
    }

    public Call<IPFSDesktop> swarmFiltersRm(String arg) {
        return ipfsDesktopAPI.swarmFiltersRm(arg);
    }

    public Call<IPFSDesktop> swarmPeeringAdd(String arg) {
        return ipfsDesktopAPI.swarmPeeringAdd(arg);
    }

    public Call<IPFSDesktop> swarmPeeringLs() {
        return ipfsDesktopAPI.swarmPeeringLs();
    }

    public Call<IPFSDesktop> swarmPeeringRm(String arg) {
        return ipfsDesktopAPI.swarmPeeringRm(arg);
    }

    public Call<IPFSDesktop> swarmPeers(boolean verbose,
                                        boolean streams,
                                        boolean latency,
                                        boolean direction) {
        return ipfsDesktopAPI.swarmPeers(verbose, streams, latency, direction);
    }

    public Call<IPFSDesktop> tarAdd() {
        return ipfsDesktopAPI.tarAdd();
    }

    public Call<IPFSDesktop> tarCat(String arg) {
        return ipfsDesktopAPI.tarCat(arg);
    }

    public Call<IPFSDesktop> update(String arg) {
        return ipfsDesktopAPI.update(arg);
    }

    public Call<IPFSDesktop> urlstoreAdd(String arg,
                                         boolean trickle,
                                         boolean pin) {
        return ipfsDesktopAPI.urlstoreAdd(arg, trickle, pin);
    }

    public Call<IPFSDesktop> version(boolean number,
                                     boolean commit,
                                     boolean repo,
                                     boolean all) {
        return ipfsDesktopAPI.version(number, commit, repo, all);
    }

    public Call<IPFSDesktop> versionDeps() {
        return ipfsDesktopAPI.versionDeps();
    }
}
