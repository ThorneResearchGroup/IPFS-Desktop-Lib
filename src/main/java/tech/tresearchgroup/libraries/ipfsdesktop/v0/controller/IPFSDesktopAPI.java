package tech.tresearchgroup.libraries.ipfsdesktop.v0.controller;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;
import tech.tresearchgroup.libraries.ipfsdesktop.v0.model.IPFSDesktop;

import java.io.File;

public interface IPFSDesktopAPI {
    /**
     * Add a file or directory to IPFS
     * @param file The file you wish to add
     * @param quiet Write minimal output. Required: no
     * @param quieter Write only final hash. Required: no
     * @param silent Write no output. Required: no
     * @param progress Stream progress data. Required: no
     * @param trickle Use trickle-dag format for dag generation. Required: no
     * @param onlyHash Only chunk and hash - do not write to disk. Required: no
     * @param wrapWithDirectory Wrap files with a directory object. Required: no
     * @param chunker Chunking algorithm, size-[bytes], rabin-[min]-[avg]-[max] or buzhash. Default: size-262144. Required: no
     * @param pin Pin this object when adding. Default: true. Required: no
     * @param rawLeaves Use raw blocks for leaf nodes. Required: no
     * @param noCopy Add the file using filestore. Implies raw-leaves. (experimental). Required: no
     * @param fsCache Check the filestore for pre-existing blocks. (experimental). Required: no
     * @param cidVersion CID version. Defaults to 0 unless an option that depends on CIDv1 is passed. Passing version 1 will cause the raw-leaves option to default to true. Required: no
     * @param hash Hash function to use. Implies CIDv1 if not sha2-256. (experimental). Default: sha2-256. Required: no
     * @param inline Inline small blocks into CIDs. (experimental). Required: no
     * @param inlineLimit Maximum block size to inline. (experimental). Default: 32. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/add")
    Call<IPFSDesktop> add(@Body File file,
                          @Query("quiet") boolean quiet,
                          @Query("quieter") boolean quieter,
                          @Query("silent") boolean silent,
                          @Query("progress") boolean progress,
                          @Query("trickle") boolean trickle,
                          @Query("only-hash") boolean onlyHash,
                          @Query("wrap-with-directory") boolean wrapWithDirectory,
                          @Query("chunker") String chunker,
                          @Query("pin") boolean pin,
                          @Query("raw-leaves") boolean rawLeaves,
                          @Query("nocopy") boolean noCopy,
                          @Query("fscache") boolean fsCache,
                          @Query("cid-version") int cidVersion,
                          @Query("hash") String hash,
                          @Query("inline") boolean inline,
                          @Query("inline-limit") int inlineLimit);

    /**
     * Show the current ledger for a peer
     * @param arg The PeerID (B58) of the ledger to inspect. Required: yes
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/bitswap")
    Call<IPFSDesktop> bitswap(@Query("arg") String arg);

    /**
     * Trigger reprovider
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/bitswap/reprovide")
    Call<IPFSDesktop> bitswapReprovide();

    /**
     * Show some diagnostic information on the bitswap agent
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/bitswap/stat")
    Call<IPFSDesktop> bitswapStat(@Query("verbose") boolean verbose,
                                  @Query("human") boolean human);

    /**
     * Show blocks currently on the wantlist
     * @param peer Specify which peer to show wantlist for. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/bitswap/wantlist")
    Call<IPFSDesktop> bitswapWantList(@Query("peer") String peer);

    /**
     * Get a raw IPFS block
     * @param arg The base58 multihash of an existing block to get. Required: yes
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/block/get")
    Call<IPFSDesktop> blockGet(@Query("arg") String arg);

    /**
     * Store input as an IPFS block
     * @param file The block as a file
     * @param format cid format for blocks to be created with. Required: no
     * @param mhType multihash hash function. Default: sha2-256. Required: no
     * @param mhLen multihash hash length. Default: -1. Required: no
     * @param pin pin added blocks recursively. Default: false. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/block/put")
    Call<IPFSDesktop> blockPut(@Body File file,
                               @Query("format") String format,
                               @Query("mhtype") String mhType,
                               @Query("mhlen") int mhLen,
                               @Query("pin") boolean pin);

    /**
     * Remove IPFS block(s)
     * @param arg Bash58 encoded multihash of block(s) to remove. Required: yes
     * @param force Ignore nonexistent blocks. Required: no
     * @param quiet Write minimal output. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/block/rm")
    Call<IPFSDesktop> blockRm(@Query("arg") String arg,
                              @Query("force") boolean force,
                              @Query("quiet") boolean quiet);

    /**
     * Print information of a raw IPFS block
     * @param arg The base58 multihash of an existing block to stat. Required: yes
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/block/stat")
    Call<IPFSDesktop> blockStat(@Query("arg") String arg);

    /**
     * Show or edit the list of bootstrap peers
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/bootstrap")
    Call<IPFSDesktop> bootstrap();

    /**
     * Add peers to the bootstrap list
     * @param arg peer to add to the bootstrap list (in the format '<multiaddr>/<peerID>') Required: no
     * @param isDefault Add default bootstrap nodes. (Deprecated, use 'default' subcommand instead). Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/bootstrap/add")
    Call<IPFSDesktop> bootstrapAdd(@Query("arg") String arg,
                                   @Query("default") boolean isDefault);

    /**
     * Add default peers to the bootstrap list
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/bootstrap/add/default")
    Call<IPFSDesktop> bootstrapAddDefault();

    /**
     * Show peers in the bootstrap list
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/bootstrap/list")
    Call<IPFSDesktop> bootstrapList();

    /**
     * Remove peers from the bootstrap list
     * @param arg A peer to add to the bootstrap list (in the format '<multiaddr>/<peerID>') Required: no
     * @param all Remove all bootstrap peers. (Deprecated, use 'all' subcommand). Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/bootstrap/rm")
    Call<IPFSDesktop> bootstrapRm(@Query("arg") String arg,
                                  @Query("all") boolean all);

    /**
     * Remove all peers from the bootstrap list
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/bootstrap/rm/all")
    Call<IPFSDesktop> bootstrapRmAll();

    /**
     * Show IPFS object data
     * @param arg The path to the IPFS object(s) to be outputted. Required: yes
     * @param offset Byte offset to begin reading from. Required: no
     * @param length Maximum number of bytes to read. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/cat")
    Call<IPFSDesktop> cat(@Query("arg") String arg,
                          @Query("offset") int offset,
                          @Query("length") int length);

    /**
     * Convert CIDs to Base32 CID version 1
     * @param arg Cids to convert. Required: yes
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/cid/base32")
    Call<IPFSDesktop> cidBase32(@Query("arg") String arg);

    /**
     * List available multibase encodings
     * @param prefix also include the single letter prefixes in addition to the code. Required: no
     * @param numeric also include numeric codes. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/cid/bases")
    Call<IPFSDesktop> cidBases(@Query("prefix") boolean prefix,
                               @Query("numeric") boolean numeric);

    /**
     * List available CID codecs
     * @param numeric also include numeric codes. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/cid/codecs")
    Call<IPFSDesktop> cidCodecs(@Query("numeric") boolean numeric);

    /**
     * Format and convert a CID in various useful ways
     * @param arg Cids to format. Required: yes
     * @param f Printf style format string. Default: %s. Default: %s. Required: no
     * @param v CID version to convert to. Required: no
     * @param codec CID codec to convert to. Required: no
     * @param b Multibase to display CID in. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/cid/format")
    Call<IPFSDesktop> cidFormat(@Query("arg") String arg,
                                @Query("f") String f,
                                @Query("v") String v,
                                @Query("codec") String codec,
                                @Query("b") String b);

    /**
     * List available multihashes
     * @param numeric also include numeric codes. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/cid/hashes")
    Call<IPFSDesktop> cidHashes(@Query("numeric") boolean numeric);

    /**
     * List all available commands
     * @param flags Show command flags. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/commands")
    Call<IPFSDesktop> commands(@Query("flags") boolean flags);

    /**
     * Generate bash shell completions
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/commands/completion/bash")
    Call<IPFSDesktop> commandsCompletionBash();

    /**
     * Get and set IPFS config values
     * @param firstArg The key of the config entry (e.g. "Addresses.API"). Required: yes
     * @param secondArg The value to set the config entry to. Required: no
     * @param bool Set a boolean value. Required: no
     * @param json Parse stringified JSON. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/config")
    Call<IPFSDesktop> config(@Query("arg") String firstArg,
                             @Query("arg") String secondArg,
                             @Query("bool") boolean bool,
                             @Query("json") boolean json);

    /**
     * Open the config file for editing in $EDITOR
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/config/edit")
    Call<IPFSDesktop> configEdit();

    /**
     * Apply profile to config
     * @param arg The profile to apply to the config. Required: yes
     * @param dryRun print difference between the current config and the config that would be generated. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/config/profile/apply")
    Call<IPFSDesktop> configProfileApply(@Query("arg") String arg,
                                         @Query("dry-run") boolean dryRun);

    /**
     * Replace the config with <file>
     * @param file The file you wish to replace your config with
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/config/replace")
    Call<IPFSDesktop> configReplace(@Body File file);

    /**
     * Output config file contents
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/config/show")
    Call<IPFSDesktop> configShow();

    /**
     * Streams the selected DAG as a .car stream on stdout
     * @param arg CID of a root to recursively export Required: yes
     * @param progress Display progress on CLI. Defaults to true when STDERR is a TTY. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/dag/export")
    Call<IPFSDesktop> dagExport(@Query("arg") String arg,
                                @Query("progress") boolean progress);

    /**
     * Get a DAG node from IPFS
     * @param arg The object to get Required: yes
     * @param outputCodec Format that the object will be encoded as. Default: dag-json. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/dag/get")
    Call<IPFSDesktop> dagGet(@Query("arg") String arg,
                             @Query("output-codec") String outputCodec);

    /**
     * Import the contents of .car files
     * @param pinRoots Pin optional roots listed in the .car headers after importing. Default: true. Required: no
     * @param silent No output. Required: no
     * @param stats Output stats. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/dag/import")
    Call<IPFSDesktop> dagImport(@Query("pin-roots") boolean pinRoots,
                                @Query("silent") boolean silent,
                                @Query("stats") boolean stats);

    /**
     * Add a DAG node to IPFS
     * @param storeCodec Codec that the stored object will be encoded with. Default: dag-cbor. Required: no
     * @param inputCodec Codec that the input object is encoded in. Default: dag-json. Required: no
     * @param pin Pin this object when adding. Required: no
     * @param hash Hash function to use. Default: sha2-256. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/dag/put")
    Call<IPFSDesktop> dagPut(@Query("store-codec") String storeCodec,
                             @Query("input-codec") String inputCodec,
                             @Query("pin") boolean pin,
                             @Query("hash") String hash);

    /**
     * Resolve IPLD block
     * @param arg The path to resolve Required: yes
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/dag/resolve")
    Call<IPFSDesktop> dagResolve(@Query("arg") String arg);

    /**
     * Gets stats for a DAG
     * @param arg CID of a DAG root to get statistics for Required: yes
     * @param progress Return progressive data while reading through the DAG. Default: true. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/dag/stat")
    Call<IPFSDesktop> dagStat(@Query("arg") String arg,
                              @Query("progress") boolean progress);

    /**
     * Find the multiaddresses associated with a Peer ID
     * @param arg The ID of the peer to search for. Required: yes
     * @param verbose Print extra information. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/dht/findpeer")
    Call<IPFSDesktop> dhtFindPeer(@Query("arg") String arg,
                                  @Query("verbose") boolean verbose);

    /**
     * Find peers that can provide a specific value, given a key
     * @param arg The key to find providers for. Required: yes
     * @param verbose Print extra information. Required: no
     * @param numProviders The number of providers to find. Default: 20. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/dht/findprovs")
    Call<IPFSDesktop> dhtFindProvs(@Query("arg") String arg,
                                   @Query("verbose") boolean verbose,
                                   @Query("num-providers") int numProviders);

    /**
     * Given a key, query the routing system for its best value
     * @param arg The key to find a value for. Required: yes
     * @param verbose Print extra information. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/dht/get")
    Call<IPFSDesktop> dhtGet(@Query("arg") String arg,
                             @Query("verbose") boolean verbose);

    /**
     * Announce to the network that you are providing given values
     * @param arg The key[s] to send provide records for. Required: yes
     * @param verbose Print extra information. Required: no
     * @param recursive Recursively provide entire graph. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/dht/provide")
    Call<IPFSDesktop> dhtProvide(@Query("arg") String arg,
                                 @Query("verbose") boolean verbose,
                                 @Query("recursive") boolean recursive);

    /**
     * Write a key/value pair to the routing system
     * @param arg The key to store the value at. Required: yes
     * @param verbose Print extra information. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/dht/put")
    Call<IPFSDesktop> dhtPut(@Query("arg") String arg,
                             @Query("verbose") boolean verbose);

    /**
     * Find the closest Peer IDs to a given Peer ID by querying the DHT
     * @param arg The peerID to run the query against. Required: yes
     * @param verbose Print extra information. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/dht/query")
    Call<IPFSDesktop> dhtQuery(@Query("arg") String arg,
                               @Query("verbose") boolean verbose);

    /**
     * List commands run on this IPFS node
     * @param verbose Print extra information. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/diag/cmds")
    Call<IPFSDesktop> diagCmds(@Query("verbose") boolean verbose);

    /**
     * Clear inactive requests from the log
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/diag/cmds/clear")
    Call<IPFSDesktop> diagCmdsClear();

    /**
     * Set how long to keep inactive requests in the log
     * @param arg Time to keep inactive requests in log. Required: yes
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/diag/cmds/set-time")
    Call<IPFSDesktop> diagCmdsSetTime(@Query("arg") String arg);

    /**
     *
     * @param output The path where the output should be stored. Required: no
     * @param cpuProfileTime The amount of time spent profiling CPU usage. Default: 30s. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/diag/profile")
    Call<IPFSDesktop> diagProfile(@Query("output") String output,
                                  @Query("cpu-profile-time") String cpuProfileTime);

    /**
     * Print system diagnostic information
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/diag/sys")
    Call<IPFSDesktop> diagSys();

    /**
     * Resolve DNS links
     * @param arg The domain-name name to resolve. Required: yes
     * @param recursive Resolve until the result is not a DNS link. Default: true. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/dns")
    Call<IPFSDesktop> dns(@Query("arg") String arg,
                          @Query("recursive") boolean recursive);

    /**
     * List directory contents for Unix filesystem objects. Deprecated: Use 'ipfs ls' instead
     * @param arg The path to the IPFS object(s) to list links from. Required: yes
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/file/ls")
    Call<IPFSDesktop> fileLs(@Query("arg") String arg);

    /**
     * Change the CID version or hash function of the root node of a given path
     * @param arg Path to change. Default: '/'. Required: no
     * @param cidVersion Cid version to use. (experimental). Required: no
     * @param hash Hash function to use. Will set Cid version to 1 if used. (experimental). Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/files/chcid")
    Call<IPFSDesktop> filesChcid(@Query("arg") String arg,
                                 @Query("cid-version") int cidVersion,
                                 @Query("hash") String hash);

    /**
     * Add references to IPFS files and directories in MFS (or copy within MFS)
     * @param firstArg Source IPFS or MFS path to copy. Required: yes
     * @param secondArg Destination within MFS. Required: yes
     * @param parents Make parent directories as needed. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/files/cp")
    Call<IPFSDesktop> filesCp(@Query("arg") String firstArg,
                              @Query("arg") String secondArg,
                              @Query("parents") boolean parents);

    /**
     * Flush a given path's data to disk
     * @param arg Path to flush. Default: '/'. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/files/flush")
    Call<IPFSDesktop> filesFlush(@Query("arg") String arg);

    /**
     * List directories in the local mutable namespace
     * @param arg Path to show listing for. Defaults to '/'. Required: no
     * @param longList Use long listing format. Required: no
     * @param u Do not sort; list entries in directory order. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/files/ls")
    Call<IPFSDesktop> filesLs(@Query("arg") String arg,
                              @Query("long") boolean longList,
                              @Query("U") boolean u);

    /**
     * Make directories
     * @param arg Path to dir to make. Required: yes
     * @param parents No error if existing, make parent directories as needed. Required: no
     * @param cidVersion Cid version to use. (experimental). Required: no
     * @param hash Hash function to use. Will set Cid version to 1 if used. (experimental). Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/files/mkdir")
    Call<IPFSDesktop> filesMkdir(@Query("arg") String arg,
                                 @Query("parents") boolean parents,
                                 @Query("cid-version") int cidVersion,
                                 @Query("hash") String hash);

    /**
     * Move files
     * @param firstArg Source file to move. Required: yes
     * @param secondArg Destination path for file to be moved to. Required: yes
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/files/mv")
    Call<IPFSDesktop> filesMv(@Query("arg") String firstArg,
                              @Query("arg") String secondArg);

    /**
     * Read a file in a given MFS
     * @param arg Path to file to be read. Required: yes
     * @param offset Byte offset to begin reading from. Required: no
     * @param count Maximum number of bytes to read. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/files/read")
    Call<IPFSDesktop> filesRead(@Query("arg") String arg,
                                @Query("offset") int offset,
                                @Query("count") int count);

    /**
     * Remove a file
     * @param arg File to remove. Required: yes
     * @param recursive Recursively remove directories. Required: no
     * @param force Forcibly remove target at path; implies -r for directories. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/files/rm")
    Call<IPFSDesktop> filesRm(@Query("arg") String arg,
                              @Query("recursive") boolean recursive,
                              @Query("force") boolean force);

    /**
     * Display file status
     * @param arg Path to node to stat. Required: yes
     * @param format Print statistics in given format. Allowed tokens: <hash> <size> <cumulsize> <type> <childs>. Conflicts with other format options. Default: <hash>
     * Size: <size>
     * CumulativeSize: <cumulsize>
     * ChildBlocks: <childs>
     * Type: <type>. Default: <hash> Size: <size> CumulativeSize: <cumulsize> ChildBlocks: <childs> Type: <type>. Required: no
     * @param hash Print only hash. Implies '--format=<hash>'. Conflicts with other format options. Required: no
     * @param size Print only size. Implies '--format=<cumulsize>'. Conflicts with other format options. Required: no
     * @param withLocal Compute the amount of the dag that is local, and if possible the total size. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/files/stat")
    Call<IPFSDesktop> filesStat(@Query("arg") String arg,
                                @Query("format") String format,
                                @Query("hash") boolean hash,
                                @Query("size") boolean size,
                                @Query("with-local") boolean withLocal);

    /**
     * Write to a mutable file in a given filesystem
     * @param arg Path to write to. Required: yes
     * @param offset Byte offset to begin writing at. Required: no
     * @param create Create the file if it does not exist. Required: no
     * @param parents Make parent directories as needed. Required: no
     * @param truncate Truncate the file to size zero before writing. Required: no
     * @param count Maximum number of bytes to read. Required: no
     * @param rawLeaves Use raw blocks for newly created leaf nodes. (experimental). Required: no
     * @param cidVersion Cid version to use. (experimental). Required: no
     * @param hash Hash function to use. Will set Cid version to 1 if used. (experimental). Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/files/write")
    Call<IPFSDesktop> filesWrite(@Query("arg") String arg,
                                 @Query("offset") int offset,
                                 @Query("create") boolean create,
                                 @Query("parents") boolean parents,
                                 @Query("truncate") boolean truncate,
                                 @Query("count") int count,
                                 @Query("raw-leaves") boolean rawLeaves,
                                 @Query("cid-version") int cidVersion,
                                 @Query("hash") String hash);

    /**
     * List blocks that are both in the filestore and standard block storage
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/filestore/dups")
    Call<IPFSDesktop> filestoreDups();

    /**
     * List objects in filestore
     * @param arg Cid of objects to list. Required: no
     * @param fileOrder sort the results based on the path of the backing file. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/filestore/ls")
    Call<IPFSDesktop> filestoreLs(@Query("arg") String arg,
                                  @Query("file-order") boolean fileOrder);

    /**
     * Verify objects in filestore
     * @param arg Cid of objects to verify. Required: no
     * @param fileOrder verify the objects based on the order of the backing file. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/filestore/verify")
    Call<IPFSDesktop> filestoreVerify(@Query("arg") String arg,
                                      @Query("file-order") boolean fileOrder);

    /**
     * Download IPFS objects
     * @param arg The path to the IPFS object(s) to be outputted. Required: yes
     * @param output The path where the output should be stored. Required: no
     * @param archive Output a TAR archive. Required: no
     * @param compress Compress the output with GZIP compression. Required: no
     * @param compressionLevel The level of compression (1-9). Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/get")
    Call<IPFSDesktop> get(@Query("arg") String arg,
                          @Query("output") String output,
                          @Query("archive") boolean archive,
                          @Query("compress") boolean compress,
                          @Query("compression-level") int compressionLevel);

    /**
     * Show IPFS node id info
     * @param arg Peer.ID of node to look up. Required: no
     * @param format Optional output format. Required: no
     * @param peeridBase Encoding used for peer IDs: Can either be a multibase encoded CID or a base58btc encoded multihash. Takes {b58mh|base36|k|base32|b...}. Default: b58mh. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/id")
    Call<IPFSDesktop> id(@Query("arg") String arg,
                         @Query("format") String format,
                         @Query("peerid-base") String peeridBase);

    /**
     * Export a keypair
     * @param arg name of key to export Required: yes
     * @param output The path where the output should be stored. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/key/export")
    Call<IPFSDesktop> keyExport(@Query("arg") String arg,
                                @Query("output") String output);

    /**
     * Create a new keypair
     * @param arg name of key to create Required: yes
     * @param type type of the key to create: rsa, ed25519. Default: ed25519. Required: no
     * @param size size of the key to generate. Required: no
     * @param ipnsBase Encoding used for keys: Can either be a multibase encoded CID or a base58btc encoded multihash. Takes {b58mh|base36|k|base32|b...}. Default: base36. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/key/gen")
    Call<IPFSDesktop> keyGen(@Query("arg") String arg,
                             @Query("type") String type,
                             @Query("size") int size,
                             @Query("ipns-base") String ipnsBase);

    /**
     * Import a key and prints imported key id
     * @param arg name to associate with key in keychain Required: yes
     * @param ipnsBase Encoding used for keys: Can either be a multibase encoded CID or a base58btc encoded multihash. Takes {b58mh|base36|k|base32|b...}. Default: base36. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/key/import")
    Call<IPFSDesktop> keyImport(@Query("arg") String arg,
                                @Query("ipns-base") String ipnsBase);

    /**
     * List all local keypairs
     * @param l Show extra information about keys. Required: no
     * @param ipnsBase Encoding used for keys: Can either be a multibase encoded CID or a base58btc encoded multihash. Takes {b58mh|base36|k|base32|b...}. Default: base36. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/key/list")
    Call<IPFSDesktop> keyList(@Query("l") boolean l,
                              @Query("ipns-base") String ipnsBase);

    /**
     * Rename a keypair
     * @param firstArg name of key to rename Required: yes
     * @param secondArg new name of the key Required: yes
     * @param force Allow to overwrite an existing key. Required: no
     * @param ipnsBase Encoding used for keys: Can either be a multibase encoded CID or a base58btc encoded multihash. Takes {b58mh|base36|k|base32|b...}. Default: base36. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/key/rename")
    Call<IPFSDesktop> keyRename(@Query("arg") String firstArg,
                                @Query("arg") String secondArg,
                                @Query("force") boolean force,
                                @Query("ipns-base") String ipnsBase);

    /**
     * Remove a keypair
     * @param arg names of keys to remove Required: yes
     * @param l Show extra information about keys. Required: no
     * @param ipnsBase Encoding used for keys: Can either be a multibase encoded CID or a base58btc encoded multihash. Takes {b58mh|base36|k|base32|b...}. Default: base36. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/key/rm")
    Call<IPFSDesktop> keyRm(@Query("arg") String arg,
                            @Query("l") boolean l,
                            @Query("ipns-base") String ipnsBase);

    /**
     * Rotates the IPFS identity
     * @param oldKey Keystore name to use for backing up your existing identity. Required: no
     * @param type type of the key to create: rsa, ed25519. Default: ed25519. Required: no
     * @param size size of the key to generate. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/key/rotate")
    Call<IPFSDesktop> keyRotate(@Query("oldkey") String oldKey,
                                @Query("type") String type,
                                @Query("size") int size);

    /**
     * Change the logging level
     * @param firstArg The subsystem logging identifier. Use 'all' for all subsystems. Required: yes
     * @param secondArg The log level, with 'debug' the most verbose and 'fatal' the least verbose.
     * One of: debug, info, warn, error, dpanic, panic, fatal.
     * Required: yes
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/log/level")
    Call<IPFSDesktop> logLevel(@Query("arg") String firstArg,
                               @Query("arg") String secondArg);

    /**
     * List the logging subsystems
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/log/ls")
    Call<IPFSDesktop> logLs();

    /**
     * Read the event log
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/log/tail")
    Call<IPFSDesktop> logTail();

    /**
     * List directory contents for Unix filesystem objects
     * @param arg The path to the IPFS object(s) to list links from. Required: yes
     * @param headers Print table headers (Hash, Size, Name). Required: no
     * @param resolveType Resolve linked objects to find out their types. Default: true. Required: no
     * @param size Resolve linked objects to find out their file size. Default: true. Required: no
     * @param stream Enable experimental streaming of directory entries as they are traversed. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/ls")
    Call<IPFSDesktop> ls(@Query("arg") String arg,
                         @Query("headers") boolean headers,
                         @Query("resolve-type") boolean resolveType,
                         @Query("size") boolean size,
                         @Query("stream") boolean stream);

    /**
     * Mounts IPFS to the filesystem (read-only)
     * @param ipfsPath The path where IPFS should be mounted. Required: no
     * @param ipnsPath The path where IPNS should be mounted. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/mount")
    Call<IPFSDesktop> mount(@Query("ipfs-path") String ipfsPath,
                            @Query("ipns-path") String ipnsPath);

    /**
     * Decode multibase string
     * @param file This endpoint expects one or several files (depending on the command) in the body of the request as 'multipart/form-data'
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/multibase/decode")
    Call<IPFSDesktop> multibaseDecode(@Body File file);

    /**
     * Encode data into multibase string
     * @param b multibase encoding. Default: base64url. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/multibase/encode")
    Call<IPFSDesktop> multibaseEncode(@Query("b") String b);

    /**
     * List available multibase encodings
     * @param prefix also include the single letter prefixes in addition to the code. Required: no
     * @param numeric also include numeric codes. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/multibase/list")
    Call<IPFSDesktop> multibaseList(@Query("prefix") boolean prefix,
                                    @Query("numeric") boolean numeric);

    /**
     * Transcode multibase string between bases
     * @param b multibase encoding. Default: base64url. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/multibase/transcode")
    Call<IPFSDesktop> multibaseTranscode(@Query("b") String b);

    /**
     * Publish IPNS names
     * @param arg ipfs path of the object to be published. Required: yes
     * @param resolve Check if the given path can be resolved before publishing. Default: true. Required: no
     * @param lifetime Time duration that the record will be valid for.
     * This accepts durations such as "300s", "1.5h" or "2h45m". Valid time units are
     * "ns", "us" (or "µs"), "ms", "s", "m", "h". Default: 24h. Required: no
     * @param allowOffline When offline, save the IPNS record to the the local datastore without broadcasting to the network instead of simply failing. Required: no
     * @param ttl Time duration this record should be cached for. Uses the same syntax as the lifetime option. (caution: experimental). Required: no
     * @param key Name of the key to be used or a valid PeerID, as listed by 'ipfs key list -l'. Default: self. Required: no
     * @param quieter Write only final hash. Required: no
     * @param ipnsBase Encoding used for keys: Can either be a multibase encoded CID or a base58btc encoded multihash. Takes {b58mh|base36|k|base32|b...}. Default: base36. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/name/publish")
    Call<IPFSDesktop> namePublish(@Query("arg") String arg,
                                  @Query("resolve") boolean resolve,
                                  @Query("lifetime") String lifetime,
                                  @Query("allow-offline") boolean allowOffline,
                                  @Query("ttl") String ttl,
                                  @Query("key") String key,
                                  @Query("quieter") boolean quieter,
                                  @Query("ipns-base") String ipnsBase);

    /**
     * Cancel a name subscription
     * @param arg Name to cancel the subscription for. Required: yes
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/name/pubsub/cancel")
    Call<IPFSDesktop> namePubsubCancel(@Query("arg") String arg);

    /**
     * Query the state of IPNS pubsub
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/name/pubsub/state")
    Call<IPFSDesktop> namePubsubState();

    /**
     * Show current name subscriptions
     * @param ipnsBase Encoding used for keys: Can either be a multibase encoded CID or a base58btc encoded multihash. Takes {b58mh|base36|k|base32|b...}. Default: base36. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/name/pubsub/subs")
    Call<IPFSDesktop> namePubsubSubs(@Query("ipns-base") String ipnsBase);

    /**
     * Resolve IPNS names
     * @param arg The IPNS name to resolve. Defaults to your node's peerID. Required: no
     * @param recursive Resolve until the result is not an IPNS name. Default: true. Required: no
     * @param nocache Do not use cached entries. Required: no
     * @param dhtRecordCount Number of records to request for DHT resolution. Required: no
     * @param dhtTimeout Max time to collect values during DHT resolution eg "30s". Pass 0 for no timeout. Required: no
     * @param stream Stream entries as they are found. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/name/resolve")
    Call<IPFSDesktop> nameResolve(@Query("arg") String arg,
                                  @Query("recursive") boolean recursive,
                                  @Query("nocache") boolean nocache,
                                  @Query("dht-record-count") int dhtRecordCount,
                                  @Query("dht-timeout") String dhtTimeout,
                                  @Query("stream") boolean stream);

    /**
     * Deprecated way to read the raw bytes of a dag-pb object: use 'dag get' instead
     * @param arg Key of the object to retrieve, in base58-encoded multihash format. Required: yes
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/object/data")
    Call<IPFSDesktop> objectData(@Query("arg") String arg);

    /**
     * Display the diff between two IPFS objects
     * @param firstArg Object to diff against. Required: yes
     * @param secondArg Object to diff. Required: yes
     * @param verbose Print extra information. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/object/diff")
    Call<IPFSDesktop> objectDiff(@Query("arg") String firstArg,
                                 @Query("arg") String secondArg,
                                 @Query("verbose") boolean verbose);

    /**
     * Deprecated way to get and serialize the dag-pb node. Use 'dag get' instead
     * @param arg Key of the dag-pb object to retrieve, in base58-encoded multihash format. Required: yes
     * @param dataEncoding Encoding type of the data field, either "text" or "base64". Default: text. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/object/get")
    Call<IPFSDesktop> objectGet(@Query("arg") String arg,
                                @Query("data-encoding") String dataEncoding);

    /**
     * Deprecated way to output links in the specified dag-pb object: use 'dag get' instead
     * @param arg Key of the dag-pb object to retrieve, in base58-encoded multihash format. Required: yes
     * @param headers Print table headers (Hash, Size, Name). Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/object/links")
    Call<IPFSDesktop> objectLinks(@Query("arg") String arg,
                                  @Query("headers") boolean headers);

    /**
     * Deprecated way to create a new dag-pb object from a template
     * @param arg Template to use. Optional. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/object/new")
    Call<IPFSDesktop> objectNew(@Query("arg") String arg);

    /**
     * Deprecated way to add a link to a given dag-pb
     * @param firstArg The hash of the node to modify. Required: yes
     * @param secondArg Name of link to create. Required: yes
     * @param thirdArg IPFS object to add link to. Required: yes
     * @param create Create intermediary nodes. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/object/patch/add-link")
    Call<IPFSDesktop> objectPatchAddLink(@Query("arg") String firstArg,
                                         @Query("arg") String secondArg,
                                         @Query("arg") String thirdArg,
                                         @Query("create") boolean create);

    /**
     * Deprecated way to append data to the data segment of a DAG node
     * @param arg The hash of the node to modify. Required: yes
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/object/patch/append-data")
    Call<IPFSDesktop> objectPatchAppendData(@Query("arg") String arg);

    /**
     * Deprecated way to remove a link from dag-pb object
     * @param firstArg The hash of the node to modify. Required: yes
     * @param secondArg Name of the link to remove. Required: yes
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/object/patch/rm-link")
    Call<IPFSDesktop> objectPatchRmLink(@Query("arg") String firstArg,
                                        @Query("arg") String secondArg);

    /**
     * Deprecated way to set the data field of dag-pb object
     * @param arg The hash of the node to modify. Required: yes
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/object/patch/set-data")
    Call<IPFSDesktop> objectPatchSetData(@Query("arg") String arg);

    /**
     * Deprecated way to store input as a DAG object. Use 'dag put' instead
     * @param inputenc Encoding type of input data. One of: {"protobuf", "json"}. Default: json. Required: no
     * @param datafieldenc Encoding type of the data field, either "text" or "base64". Default: text. Required: no
     * @param pin Pin this object when adding. Required: no
     * @param quiet Write minimal output. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/object/put")
    Call<IPFSDesktop> objectPut(@Query("inputenc") String inputenc,
                                @Query("datafieldenc") String datafieldenc,
                                @Query("pin") boolean pin,
                                @Query("quiet") boolean quiet);

    /**
     * Deprecated way to read stats for the dag-pb node. Use 'files stat' instead
     * @param arg Key of the object to retrieve, in base58-encoded multihash format. Required: yes
     * @param human Print sizes in human readable format (e.g., 1K 234M 2G). Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/object/stat")
    Call<IPFSDesktop> objectStat(@Query("arg") String arg,
                                 @Query("human") boolean human);

    /**
     * Stop listening for new connections to forward
     * @param all Close all listeners. Required: no
     * @param protocol Match protocol name. Required: no
     * @param listenAddress Match listen address. Required: no
     * @param targetAddress Match target address. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/p2p/close")
    Call<IPFSDesktop> p2pClose(@Query("all") boolean all,
                               @Query("protocol") String protocol,
                               @Query("listen-address") String listenAddress,
                               @Query("target-address") String targetAddress);

    /**
     * Forward connections to libp2p service
     * @param firstArg Protocol name. Required: yes
     * @param secondArg Listening endpoint. Required: yes
     * @param thirdArg Target endpoint. Required: yes
     * @param allowCustomProtocol Don't require /x/ prefix. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/p2p/forward")
    Call<IPFSDesktop> p2pForward(@Query("arg") String firstArg,
                                 @Query("arg") String secondArg,
                                 @Query("arg") String thirdArg,
                                 @Query("allow-custom-protocol") boolean allowCustomProtocol);

    /**
     * Create libp2p service
     * @param firstArg Protocol name. Required: yes
     * @param secondArg Target endpoint. Required: yes
     * @param allowCustomProtocol Don't require /x/ prefix. Required: no
     * @param reportPeerId Send remote base58 peerid to target when a new connection is established. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/p2p/listen")
    Call<IPFSDesktop> p2pListen(@Query("arg") String firstArg,
                                @Query("arg") String secondArg,
                                @Query("allow-custom-protocol") boolean allowCustomProtocol,
                                @Query("report-peer-id") boolean reportPeerId);

    /**
     * List active p2p listeners
     * @param headers Print table headers (Protocol, Listen, Target). Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/p2p/ls")
    Call<IPFSDesktop> p2pLs(@Query("headers") boolean headers);

    /**
     * Close active p2p stream
     * @param arg Stream identifier Required: no
     * @param all Close all streams. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/p2p/stream/close")
    Call<IPFSDesktop> p2pStreamClose(@Query("arg") String arg,
                                     @Query("all") boolean all);

    /**
     * List active p2p streams
     * @param headers Print table headers (ID, Protocol, Local, Remote). Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/p2p/stream/ls")
    Call<IPFSDesktop> p2pStreamLs(@Query("headers") boolean headers);

    /**
     * Pin objects to local storage
     * @param arg Path to object(s) to be pinned. Required: yes
     * @param recursive Recursively pin the object linked to by the specified object(s). Default: true. Required: no
     * @param progress Show progress. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/pin/add")
    Call<IPFSDesktop> pinAdd(@Query("arg") String arg,
                             @Query("recursive") boolean recursive,
                             @Query("progress") boolean progress);

    /**
     * List objects pinned to local storage
     * @param arg Path to object(s) to be listed. Required: no
     * @param type The type of pinned keys to list. Can be "direct", "indirect", "recursive", or "all". Default: all. Required: no
     * @param quiet Write just hashes of objects. Required: no
     * @param stream Enable streaming of pins as they are discovered. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/pin/ls")
    Call<IPFSDesktop> pinLs(@Query("arg") String arg,
                            @Query("type") String type,
                            @Query("quiet") boolean quiet,
                            @Query("stream") boolean stream);

    /**
     * Pin object to remote pinning service
     * @param arg Path to object(s) to be pinned. Required: yes
     * @param service Name of the remote pinning service to use (mandatory). Required: no
     * @param name An optional name for the pin. Required: no
     * @param background Add to the queue on the remote service and return immediately (does not wait for pinned status). Default: false. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/pin/remote/add")
    Call<IPFSDesktop> pinRemoteAdd(@Query("arg") String arg,
                                   @Query("service") String service,
                                   @Query("name") String name,
                                   @Query("background") boolean background);

    /**
     * List objects pinned to remote pinning service
     * @param service Name of the remote pinning service to use (mandatory). Required: no
     * @param name Return pins with names that contain the value provided (case-sensitive, exact match). Required: no
     * @param cid Return pins for the specified CIDs (comma-separated). Required: no
     * @param status Return pins with the specified statuses (queued,pinning,pinned,failed). Default: [pinned]. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/pin/remote/ls")
    Call<IPFSDesktop> pinRemoteLs(@Query("service") String service,
                                  @Query("name") String name,
                                  @Query("cid") String cid,
                                  @Query("status") String status);

    /**
     * Remove pins from remote pinning service
     * @param service Name of the remote pinning service to use (mandatory). Required: no
     * @param name Remove pins with names that contain provided value (case-sensitive, exact match). Required: no
     * @param cid Remove pins for the specified CIDs. Required: no
     * @param status Remove pins with the specified statuses (queued,pinning,pinned,failed). Default: [pinned]. Required: no
     * @param force Allow removal of multiple pins matching the query without additional confirmation. Default: false. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/pin/remote/rm")
    Call<IPFSDesktop> pinRemoteRm(@Query("service") String service,
                                  @Query("name") String name,
                                  @Query("cid") String cid,
                                  @Query("status") String status,
                                  @Query("force") boolean force);

    /**
     * Add remote pinning service
     * @param firstArg Service name. Required: yes
     * @param secondArg Service endpoint. Required: yes
     * @param thirdArg Service key. Required: yes
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/pin/remote/service/add")
    Call<IPFSDesktop> pinRemoteServiceAdd(@Query("arg") String firstArg,
                                          @Query("arg") String secondArg,
                                          @Query("arg") String thirdArg);

    /**
     * List remote pinning services
     * @param stat Try to fetch and display current pin count on remote service (queued/pinning/pinned/failed). Default: false. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/pin/remote/service/ls")
    Call<IPFSDesktop> pinRemoteServiceLs(@Query("stat") boolean stat);

    /**
     * Remove remote pinning service
     * @param arg Name of remote pinning service to remove. Required: yes
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/pin/remote/service/rm")
    Call<IPFSDesktop> pinRemoteServiceRm(@Query("arg") String arg);

    /**
     * Remove pinned objects from local storage
     * @param arg Path to object(s) to be unpinned. Required: yes
     * @param recursive Recursively unpin the object linked to by the specified object(s). Default: true. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/pin/rm")
    Call<IPFSDesktop> pinRm(@Query("arg") String arg,
                            @Query("recursive") boolean recursive);

    /**
     * Update a recursive pin
     * @param firstArg Path to old object. Required: yes
     * @param secondArg Path to a new object to be pinned. Required: yes
     * @param unpin Remove the old pin. Default: true. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/pin/update")
    Call<IPFSDesktop> pinUpdate(@Query("arg") String firstArg,
                                @Query("arg") String secondArg,
                                @Query("unpin") boolean unpin);

    /**
     * Verify that recursive pins are complete
     * @param verbose Also write the hashes of non-broken pins. Required: no
     * @param quiet Write just hashes of broken pins. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/pin/verify")
    Call<IPFSDesktop> pinVerify(@Query("verbose") boolean verbose,
                                @Query("quiet") boolean quiet);

    /**
     * Send echo request packets to IPFS hosts
     * @param arg ID of peer to be pinged. Required: yes
     * @param count Number of ping messages to send. Default: 10. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/ping")
    Call<IPFSDesktop> ping(@Query("arg") String arg,
                           @Query("count") int count);

    /**
     * List subscribed topics by name
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/pubsub/ls")
    Call<IPFSDesktop> pubsubLs();

    /**
     * List peers we are currently pubsubbing with
     * @param arg Topic to list connected peers of. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/pubsub/peers")
    Call<IPFSDesktop> pubsubPeers(@Query("arg") String arg);

    /**
     * Publish data to a given pubsub topic
     * @param arg Topic to publish to. Required: yes
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/pubsub/pub")
    Call<IPFSDesktop> pubsubPub(@Query("arg") String arg);

    /**
     * Subscribe to messages on a given topic
     * @param arg Name of topic to subscribe to. Required: yes
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/pubsub/sub")
    Call<IPFSDesktop> pubsubSub(@Query("arg") String arg);

    /**
     * List links (references) from an object
     * @param arg Path to the object(s) to list refs from. Required: yes
     * @param format Emit edges with given format. Available tokens: <src> <dst> <linkname>. Default: <dst>. Default: <dst>. Required: no
     * @param edges Emit edge format: &lt;from&gt; -&gt; &lt;to&gt;. Required: no
     * @param unique Omit duplicate refs from output. Required: no
     * @param recursive Recursively list links of child nodes. Required: no
     * @param maxDepth Only for recursive refs, limits fetch and listing to the given depth. Default: -1. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/refs")
    Call<IPFSDesktop> refs(@Query("arg") String arg,
                           @Query("format") String format,
                           @Query("edges") boolean edges,
                           @Query("unique") boolean unique,
                           @Query("recursive") boolean recursive,
                           @Query("max-depth") int maxDepth);

    /**
     * List all local references
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/refs/local")
    Call<IPFSDesktop> refsLocal();

    /**
     * Remove repo lockfiles
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/repo/fsck")
    Call<IPFSDesktop> repoFsck();

    /**
     * Perform a garbage collection sweep on the repo
     * @param streamErrors Stream errors. Required: no
     * @param quiet Write minimal output. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/repo/gc")
    Call<IPFSDesktop> repoGc(@Query("stream-errors") boolean streamErrors,
                             @Query("quiet") boolean quiet);

    /**
     * Get stats for the currently used repo
     * @param sizeOnly Only report RepoSize and StorageMax. Required: no
     * @param human Print sizes in human readable format (e.g., 1K 234M 2G). Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/repo/stat")
    Call<IPFSDesktop> repoStat(@Query("size-only") boolean sizeOnly,
                               @Query("human") boolean human);

    /**
     * Verify all blocks in repo are not corrupted
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/repo/verify")
    Call<IPFSDesktop> repoVerify();

    /**
     * Show the repo version
     * @param quiet Write minimal output. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/repo/version")
    Call<IPFSDesktop> repoVersion(@Query("quiet") boolean quiet);

    /**
     * Resolve the value of names to IPFS
     * @param arg The name to resolve. Required: yes
     * @param recursive Resolve until the result is an IPFS name. Default: true. Required: no
     * @param dhtRecordCount Number of records to request for DHT resolution. Required: no
     * @param dhtTimeout Max time to collect values during DHT resolution eg "30s". Pass 0 for no timeout. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/resolve")
    Call<IPFSDesktop> resolve(@Query("arg") String arg,
                              @Query("recursive") boolean recursive,
                              @Query("dht-record-count") int dhtRecordCount,
                              @Query("dht-timeout") String dhtTimeout);

    /**
     * Shut down the IPFS daemon
     * @return This endpoint returns a `text/plain` response body
     */
    @POST("api/v0/shutdown")
    Call<IPFSDesktop> shutdown();

    /**
     * Show some diagnostic information on the bitswap agent
     * @param verbose Print extra information. Required: no
     * @param human Print sizes in human readable format (e.g., 1K 234M 2G). Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/stats/bitswap")
    Call<IPFSDesktop> statsBitswap(@Query("verbose") boolean verbose,
                                   @Query("human") boolean human);

    /**
     * Print IPFS bandwidth information
     * @param peer Specify a peer to print bandwidth for. Required: no
     * @param proto Specify a protocol to print bandwidth for. Required: no
     * @param poll Print bandwidth at an interval. Required: no
     * @param interval Time interval to wait between updating output, if 'poll' is true.
     *
     * This accepts durations such as "300s", "1.5h" or "2h45m". Valid time units are:
     * "ns", "us" (or "µs"), "ms", "s", "m", "h". Default: 1s. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/stats/bw")
    Call<IPFSDesktop> statsBw(@Query("peer") String peer,
                              @Query("proto") String proto,
                              @Query("poll") boolean poll,
                              @Query("interval") String interval);

    /**
     * Returns statistics about the node's DHT(s)
     * @param arg The DHT whose table should be listed (wanserver, lanserver, wan, lan). wan and lan refer to client routing tables. When using the experimental DHT client only WAN is supported. Defaults to wan and lan. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/stats/dht")
    Call<IPFSDesktop> statsDht(@Query("arg") String arg);

    /**
     * Returns statistics about the node's (re)provider system
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/stats/provide")
    Call<IPFSDesktop> statsProvide();

    /**
     * Get stats for the currently used repo
     * @param sizeOnly Only report RepoSize and StorageMax. Required: no
     * @param human Print sizes in human readable format (e.g., 1K 234M 2G). Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/stats/repo")
    Call<IPFSDesktop> statsRepo(@Query("size-only") boolean sizeOnly,
                                @Query("human") boolean human);

    /**
     * List known addresses. Useful for debugging
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/swarm/addrs")
    Call<IPFSDesktop> swarmAddrs();

    /**
     * List interface listening addresses
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/swarm/addrs/listen")
    Call<IPFSDesktop> swarmAddrsListen();

    /**
     * List local addresses
     * @param id Show peer ID in addresses. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/swarm/addrs/local")
    Call<IPFSDesktop> swarmAddrsLocal(@Query("id") boolean id);

    /**
     * Open connection to a given address
     * @param arg Address of peer to connect to. Required: yes
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/swarm/connect")
    Call<IPFSDesktop> swarmConnect(@Query("arg") String arg);

    /**
     * Close connection to a given address
     * @param arg Address of peer to disconnect from. Required: yes
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/swarm/disconnect")
    Call<IPFSDesktop> swarmDisconnect(@Query("arg") String arg);

    /**
     * Manipulate address filters
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/swarm/filters")
    Call<IPFSDesktop> swarmFilters();

    /**
     * Add an address filter
     * @param arg Multiaddr to filter. Required: yes
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/swarm/filters/add")
    Call<IPFSDesktop> swarmFiltersAdd(@Query("arg") String arg);

    /**
     * Remove an address filter
     * @param arg Multiaddr filter to remove. Required: yes
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/swarm/filters/rm")
    Call<IPFSDesktop> swarmFiltersRm(@Query("arg") String arg);

    /**
     * Add peers into the peering subsystem
     * @param arg address of peer to add into the peering subsystem Required: yes
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/swarm/peering/add")
    Call<IPFSDesktop> swarmPeeringAdd(@Query("arg") String arg);

    /**
     * List peers registered in the peering subsystem
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/swarm/peering/ls")
    Call<IPFSDesktop> swarmPeeringLs();

    /**
     * Remove a peer from the peering subsystem
     * @param arg ID of peer to remove from the peering subsystem Required: yes
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/swarm/peering/rm")
    Call<IPFSDesktop> swarmPeeringRm(@Query("arg") String arg);

    /**
     * List peers with open connections
     * @param verbose display all extra information. Required: no
     * @param streams Also list information about open streams for each peer. Required: no
     * @param latency Also list information about latency to each peer. Required: no
     * @param direction Also list information about the direction of connection. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/swarm/peers")
    Call<IPFSDesktop> swarmPeers(@Query("verbose") boolean verbose,
                                 @Query("streams") boolean streams,
                                 @Query("latency") boolean latency,
                                 @Query("direction") boolean direction);

    /**
     * Import a tar file into IPFS
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/tar/add")
    Call<IPFSDesktop> tarAdd();

    /**
     * Export a tar file from IPFS
     * @param arg ipfs path of archive to export. Required: yes
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/tar/cat")
    Call<IPFSDesktop> tarCat(@Query("arg") String arg);

    /**
     *
     * @param arg Arguments for subcommand. Required: no
     * @return This endpoint returns a `text/plain` response body
     */
    @POST("api/v0/update")
    Call<IPFSDesktop> update(@Query("arg") String arg);

    /**
     * Add URL via urlstore
     * @param arg URL to add to IPFS Required: yes
     * @param trickle Use trickle-dag format for dag generation. Required: no
     * @param pin Pin this object when adding. Default: true. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/urlstore/add")
    Call<IPFSDesktop> urlstoreAdd(@Query("arg") String arg,
                                  @Query("trickle") boolean trickle,
                                  @Query("pin") boolean pin);

    /**
     * Show IPFS version information
     * @param number Only show the version number. Required: no
     * @param commit Show the commit hash. Required: no
     * @param repo Show repo version. Required: no
     * @param all Show all version information. Required: no
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/version")
    Call<IPFSDesktop> version(@Query("number") boolean number,
                              @Query("commit") boolean commit,
                              @Query("repo") boolean repo,
                              @Query("all") boolean all);

    /**
     * Shows information about dependencies used for build
     * @return On success, the call to this endpoint will return with 200 and a JSON body
     */
    @POST("api/v0/version/deps")
    Call<IPFSDesktop> versionDeps();
}
